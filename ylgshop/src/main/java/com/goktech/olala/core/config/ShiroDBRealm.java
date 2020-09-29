package com.goktech.olala.core.config;

import com.goktech.olala.core.exception.ForbiddenException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 *Realm接口实现类
 */
public class ShiroDBRealm  extends AuthorizingRealm {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);

    /**
     * 账户禁用
     */
    private static final String USER_STATUS_FORBIDDEN = "1";

    /**
     * 权限相关用户服务接口
     */
    private ShiroUserService shiroUserService;

    /**
     * 密码服务类 加密作用
     */
    private ShiroPasswordService shiroPasswordService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principalCollection);
            SecurityUtils.getSubject().logout();
            return null;
        }
        ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();
        String userName = shiroUser.getUserName();
        if(StringUtils.isNotBlank(userName)){
            SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
            try {
                Set<String> roleIds = shiroUserService.getRoles(userName);
                for (String roleId: roleIds){
                    shiroUser.setRoleId(roleId);
                }
                sazi.addRoles(roleIds);
                sazi.addStringPermissions(shiroUserService.getPermissions(userName));
                return sazi;
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
            }
        }
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ShiroUser shiroUser = shiroUserService.getShiroUser(token.getUsername());
        try {
            checkUserStatus(shiroUser);
        } catch (ForbiddenException e) {
            e.printStackTrace();
        }
        if(shiroUser != null){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser,shiroUser.getPassword(),ByteSource.Util.bytes(shiroUser.getUserName()+shiroPasswordService.getPublicSalt()),getName());
            return authenticationInfo;
        }
        return null;
    }

    /**
     * 检查用户状态
     * @param shiroUser
     */
    private void checkUserStatus(ShiroUser shiroUser) throws ForbiddenException {
        if(StringUtils.equalsIgnoreCase(shiroUser.getUserStatus(),USER_STATUS_FORBIDDEN)){
            throw new ForbiddenException("用户已被禁用");
        }
    }

    /**
     * 初始化方法
     * 设定Password校验的Hash算法与迭代次数.
     **/
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
                shiroPasswordService.getHashAlgorithm());
        matcher.setHashIterations(shiroPasswordService.getHashInterations());
        setCredentialsMatcher(matcher);
    }

    public void setShiroUserService(ShiroUserService shiroUserService) {
        this.shiroUserService = shiroUserService;
    }

    public void setShiroPasswordService(ShiroPasswordService shiroPasswordService) {
        this.shiroPasswordService = shiroPasswordService;
    }
}
