package com.goktech.olala.core.config;

import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespUserVo;
import com.goktech.olala.core.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 *Realm接口实现类
 */
@Component("authRealm")
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 用来为当前登陆成功的用户授予权限和角色（已经登陆成功了）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //得到权限字符串
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            //获取当前用户
            RespUserVo userVo = (RespUserVo) principals.fromRealm(getName()).iterator().next();
            info.addRoles(sysUserService.queryRolesByUser(userVo.getUserId())
                    .stream().map(respRoleVo -> respRoleVo.getRoleName()).collect(Collectors.toList()));
            info.addStringPermissions(sysUserService.getPermissionByUser(userVo.getUserId())
                    .stream().map(respPermissionVo -> respPermissionVo.getPermissionName()).collect(Collectors.toList()));
        } catch (Exception e){
           e.printStackTrace();
        }
        return info;
    }

    /**
     * 用来验证当前登录的用户，获取认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        try {
            //转换token
            UsernamePasswordToken upToken = (UsernamePasswordToken) authcToken;
            //根据用户名查询用户信息
            ReqSysUser reqSysUser = new ReqSysUser();
            reqSysUser.setUserName(upToken.getUsername());
            RespUserVo respUserVo = sysUserService.querySysUserByExample(reqSysUser);
            if(respUserVo == null){
                //用户名不存在
                //参数一:期望登陆后保存在subject中的信息
                //参数二:密码
                //参数三:realm的名称
                return new SimpleAuthenticationInfo(null,null, getName());
            }else{
                //用户名存在
                //当返回密码时,securityManager安全管理器会自动比较与用户传过来的密码
                //如果一致,登陆成功,如果不一致,报密码错误异常
                return new SimpleAuthenticationInfo(respUserVo, respUserVo.getPassword(), getName());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
