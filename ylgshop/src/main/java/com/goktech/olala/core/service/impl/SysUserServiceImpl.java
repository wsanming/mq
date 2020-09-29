package com.goktech.olala.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespPermissionVo;
import com.goktech.olala.core.resp.RespRoleVo;
import com.goktech.olala.core.resp.RespSysMenuVo;
import com.goktech.olala.core.resp.RespUserVo;
import com.goktech.olala.core.service.ISysUserService;
import com.goktech.olala.server.dao.sys.*;
import com.goktech.olala.server.pojo.sys.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysRoleDao sysRoleDao;

    @Autowired
    SysMenuDao sysMenuDao;

    @Autowired
    SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Override
    public RespUserVo querySysUserByExample(ReqSysUser reqSysUser) throws Exception{
        List<RespUserVo> respUserVoList = sysUserDao.selectByExample(reqSysUser);
        if (respUserVoList != null && respUserVoList.size() > 0) {
            return respUserVoList.get(0);
        }
        return null;
    }

    @Override
    public List<RespRoleVo> queryRolesByUser(Long userId) throws Exception{
        if(userId == null){
            return null;
        }
        ReqSysUser reqSysUser = new ReqSysUser();
        reqSysUser.setUserId(userId);
        return sysRoleDao.selectByExample(reqSysUser);
    }

    @Override
    public List<RespPermissionVo> getPermissionByUser(Long userId) throws Exception{
        if(userId == null){
            return null;
        }
        List<RespPermissionVo> permissionVos = new ArrayList<RespPermissionVo>();
        ReqSysUser reqSysUser = new ReqSysUser();
        reqSysUser.setUserId(userId);
        //1.根据用户ID查询此用户的角色
        List<RespRoleVo> respRoleVos = sysRoleDao.selectByExample(reqSysUser);
        if(respRoleVos != null && respRoleVos.size() > 0){
            List<RespSysMenuVo> respSysMenuVos = null;
            for (RespRoleVo roleVo: respRoleVos) {
                //2.根据角色ID查询词角色的所有权限
                reqSysUser = new ReqSysUser();
                reqSysUser.setRoleId(roleVo.getRoleId());
                respSysMenuVos = sysMenuDao.selectByExample(reqSysUser);
                if(respSysMenuVos != null && respSysMenuVos.size() > 0){
                    for (RespSysMenuVo menuVo: respSysMenuVos) {
                        RespPermissionVo permissionVo = null;
                        String perms = menuVo.getPerms();
                        //3.开始收集权限
                        if(StringUtils.isNotBlank(perms)){
                            String[] permsArr = perms.split(",");
                            for (String perm : permsArr) {
                                if(StringUtils.isBlank(perm)){
                                    continue;
                                }
                                permissionVo = new RespPermissionVo();
                                permissionVo.setPermissionId(menuVo.getMenuId());
                                permissionVo.setPermissionCode(perm);
                                permissionVo.setPermissionName(menuVo.getMenuName());
                                permissionVo.setPermissionDescr(menuVo.getMenuName());
                                permissionVos.add(permissionVo);
                            }
                        }

                    }

                }
            }
        }
        return null;
    }

    @Override
    public PageInfo<RespUserVo> queryAllAccountsForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<RespUserVo> respList = sysUserDao.selectByExample(reqSysUser);
        PageInfo<RespUserVo> pageInfo = new PageInfo<>(respList);
        return pageInfo;
    }

    @Override
    public RespUserVo queryAccountInfoById(Long userId) throws Exception {
        if(userId == null){
            return null;
        }
        RespUserVo respUserVo = new RespUserVo();
        SysUser sysUser = sysUserDao.selectByPrimaryKey(userId);
        BeanUtils.copyProperties(sysUser, respUserVo);
        return respUserVo;
    }

    @Override
    public int updateUserStatusById(Long userId, Integer status) throws Exception {
        if(userId == null || status == null){
            return 0;
        }
        return sysUserDao.updateStatusById(userId, status);
    }

    @Transactional
    @Override
    public int saveSysUserInfo(ReqSysUser reqSysUser) throws Exception{
        int result = 0;
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        SysUser sysUser = new SysUser();
        sysUser.setUserName(reqSysUser.getUserName());
        sysUser.setRealName(reqSysUser.getRealName());
        sysUser.setPassword(reqSysUser.getPassword());
        sysUser.setSalt(reqSysUser.getUserName());
        sysUser.setEmail(reqSysUser.getEmail());
        sysUser.setMobile(reqSysUser.getMobile());
        sysUser.setDeptName(reqSysUser.getDeptName());
        sysUser.setRemark(reqSysUser.getRemark());
        sysUser.setUpdateBy(SysConfig.SYSTEM_USER);
        sysUser.setUpdateTime(Timestamp.valueOf(nowTime));
        Long userId = reqSysUser.getUserId();
        if(userId != null){
            sysUser.setUserId(userId);
            result = sysUserDao.updateByPrimaryKey(sysUser);
        }else {
            sysUser.setStatus(1);
            sysUser.setCreateBy(SysConfig.SYSTEM_USER);
            sysUser.setCreateTime(Timestamp.valueOf(nowTime));
            result = sysUserDao.insertByExample(sysUser);
            userId = sysUser.getUserId();
        }
        if(result > 0){
            sysUserRoleDao.deleteByExample(userId, null);
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(reqSysUser.getRoleId());
            sysUserRole.setUserId(userId);
            result = sysUserRoleDao.insert(sysUserRole);
        }
        return result;
    }

    @Override
    public int removeSysUserById(Long userId) throws Exception {
        if(userId == null){
            return 0;
        }
        return sysUserDao.deleteByPrimaryKey(userId);
    }

    @Override
    public PageInfo<RespRoleVo> queryAllRolesForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<RespRoleVo> respList = sysRoleDao.selectByExample(reqSysUser);
        if(respList != null && respList.size() > 0){
            List<RespUserVo> respUserVoList = null;
            for (RespRoleVo roleVo : respList) {
                reqSysUser = new ReqSysUser();
                reqSysUser.setRoleId(roleVo.getRoleId());
                respUserVoList = sysUserDao.selectByExample(reqSysUser);
                if(respUserVoList != null){
                    roleVo.setUserList(respUserVoList);
                }
            }
        }
        PageInfo<RespRoleVo> pageInfo = new PageInfo<>(respList);
        return pageInfo;
    }

    @Override
    public List<RespRoleVo> queryAllSysRoles(ReqSysUser reqSysUser) throws Exception {
        return sysRoleDao.selectByExample(reqSysUser);
    }

    @Override
    public RespRoleVo querySysRoleInfoById(Long roleId) throws Exception {
        if(roleId == null){
            return null;
        }
        RespRoleVo respRoleVo = new RespRoleVo();
        SysRole sysRole = sysRoleDao.selectByPrimaryKey(roleId);
        BeanUtils.copyProperties(sysRole, respRoleVo);
        respRoleVo.setDescription(sysRole.getRemark());
        ReqSysUser reqSysUser = new ReqSysUser();
        reqSysUser.setRoleId(roleId);
        //根据角色查询菜单权限
        List<RespSysMenuVo> respSysMenuVos = sysMenuDao.selectMenusByRole(reqSysUser);
        if(respSysMenuVos != null){
            respRoleVo.setMenuVoList(respSysMenuVos);
        }
        return respRoleVo;
    }

    @Transactional
    @Override
    public int saveSysRoleInfo(ReqSysUser reqSysUser) throws Exception{
        int result = 0;
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Long roleId = reqSysUser.getRoleId();

        SysRole sysRole = new SysRole();
        sysRole.setRoleName(reqSysUser.getRoleName());
        sysRole.setRemark(reqSysUser.getRemark());
        sysRole.setDeptName(reqSysUser.getDeptName());
        sysRole.setUpdateBy(SysConfig.SYSTEM_USER);
        sysRole.setUpdateTime(Timestamp.valueOf(nowTime));
        if(roleId != null){
            sysRole.setRoleId(roleId);
            result = sysRoleDao.updateByPrimaryKey(sysRole);
        }else{
            sysRole.setCreateBy(SysConfig.SYSTEM_USER);
            sysRole.setCreateTime(Timestamp.valueOf(nowTime));
            result = sysRoleDao.insertByExample(sysRole);
            roleId = sysRole.getRoleId();
        }
        if(result > 0){
            sysRoleMenuDao.deleteByExample(roleId, null);
            Long[] direArr = reqSysUser.getDireArr();
            if(direArr != null){
                for (Long menuId: direArr) {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(roleId);
                    sysRoleMenu.setMenuId(menuId);
                    result = sysRoleMenuDao.insert(sysRoleMenu);
                }
            }
            Long[] menuArr = reqSysUser.getMenuArr();
            if(menuArr != null){
                for (Long menuId: menuArr) {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(roleId);
                    sysRoleMenu.setMenuId(menuId);
                    result = sysRoleMenuDao.insert(sysRoleMenu);
                }
            }
            Long[] permsArr = reqSysUser.getPermsArr();
            if(permsArr != null){
                for (Long menuId: permsArr) {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(roleId);
                    sysRoleMenu.setMenuId(menuId);
                    result = sysRoleMenuDao.insert(sysRoleMenu);
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public int removeSysRoleById(Long roleId) throws Exception {
        if(roleId == null){
            return 0;
        }
        int result = sysRoleMenuDao.deleteByExample(roleId, null);
        result = sysRoleDao.deleteByPrimaryKey(roleId);
        return result;
    }

    @Override
    public PageInfo<RespSysMenuVo> queryAllMenusForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<RespSysMenuVo> respList = sysMenuDao.selectByExample(reqSysUser);
        PageInfo<RespSysMenuVo> pageInfo = new PageInfo<>(respList);
        return pageInfo;
    }

    @Override
    public List<RespSysMenuVo> queryAllSysMenus(ReqSysUser reqSysUser) throws Exception {
        //查询所有的一级目录
        reqSysUser.setParentMenuId(Long.valueOf(-1));
        reqSysUser.setMenuType(0);
        List<RespSysMenuVo> respSysMenuVos = sysMenuDao.selectByExample(reqSysUser);
        List<RespSysMenuVo> childMenuVos = null;
        List<RespSysMenuVo> permsVos = null;
        List<RespSysMenuVo> respPermsVos = null;
        if(respSysMenuVos != null){
            for (RespSysMenuVo menuVo : respSysMenuVos) {
                Long dirId = menuVo.getMenuId();
                //查询二级菜单
                reqSysUser.setParentMenuId(dirId);
                reqSysUser.setMenuType(1);
                childMenuVos = sysMenuDao.selectByExample(reqSysUser);
                if(childMenuVos != null){
                    for (RespSysMenuVo childMenuVo : childMenuVos) {
                        Long menuId = childMenuVo.getMenuId();
                        //查询菜单权限
                        reqSysUser.setParentMenuId(menuId);
                        reqSysUser.setMenuType(2);
                        permsVos = sysMenuDao.selectByExample(reqSysUser);
                        if(permsVos != null){
                            respPermsVos = new ArrayList<>();
                            //封装权限列表
                            for (RespSysMenuVo  permsVo : permsVos) {
                                RespSysMenuVo respPermsVo = new RespSysMenuVo();
                                respPermsVo.setPermsId(permsVo.getMenuId());
                                respPermsVo.setPermsKey(permsVo.getPerms());
                                respPermsVo.setPermsDesc(permsVo.getMenuName());

                                respPermsVos.add(respPermsVo);
                            }
                            childMenuVo.setChildList(respPermsVos);
                        }
                    }
                }
                menuVo.setChildList(childMenuVos);
            }
        }
        return respSysMenuVos;
    }

    @Override
    public List<RespSysMenuVo> querySysMenusByRole(Long roleId) throws Exception {
        ReqSysUser reqSysUser = new ReqSysUser();
        List<Long> menuIdList = new ArrayList<Long>();
        if(roleId != null){
            List<SysRoleMenu> sysRoleMenus = sysRoleMenuDao.selectByExample(roleId, null);
            if(sysRoleMenus != null){
                for (SysRoleMenu menuObj : sysRoleMenus) {
                    menuIdList.add(menuObj.getMenuId());
                }
            }
        }
        //查询所有的一级目录
        reqSysUser.setParentMenuId(Long.valueOf(-1));
        reqSysUser.setMenuType(0);
        List<RespSysMenuVo> respMenuList = new ArrayList<>();
        List<RespSysMenuVo> restMenuList = sysMenuDao.selectByExample(reqSysUser);
        List<RespSysMenuVo> childMenuVos = null;
        List<RespSysMenuVo> permsVos = null;
        List<RespSysMenuVo> respPermsVos = null;
        if(restMenuList != null){
            for (RespSysMenuVo menuVo : restMenuList) {
                if(!menuIdList.contains(menuVo.getMenuId())){
                    continue;
                }
                Long dirId = menuVo.getMenuId();
                //查询二级菜单
                reqSysUser.setParentMenuId(dirId);
                reqSysUser.setMenuType(1);
                childMenuVos = sysMenuDao.selectByExample(reqSysUser);
                if(childMenuVos != null){
                    for (RespSysMenuVo childMenuVo : childMenuVos) {
                        if(!menuIdList.contains(childMenuVo.getMenuId())){
                            continue;
                        }
                        Long menuId = childMenuVo.getMenuId();
                        //查询菜单权限
                        reqSysUser.setParentMenuId(menuId);
                        reqSysUser.setMenuType(2);
                        permsVos = sysMenuDao.selectByExample(reqSysUser);
                        if(permsVos != null){
                            respPermsVos = new ArrayList<>();
                            //封装权限列表
                            for (RespSysMenuVo  permsVo : permsVos) {
                                if(!menuIdList.contains(permsVo.getMenuId())){
                                    continue;
                                }
                                RespSysMenuVo respPermsVo = new RespSysMenuVo();
                                respPermsVo.setPermsId(permsVo.getMenuId());
                                respPermsVo.setPermsKey(permsVo.getPerms());
                                respPermsVo.setPermsDesc(permsVo.getMenuName());

                                respPermsVos.add(respPermsVo);
                            }
                            childMenuVo.setChildList(respPermsVos);
                        }
                    }
                }
                menuVo.setChildList(childMenuVos);
                respMenuList.add(menuVo);
            }
        }
        return respMenuList;
    }

    @Override
    public RespSysMenuVo querySysMenuInfoById(Long menuId) throws Exception {
        if(menuId == null){
            return null;
        }
        RespSysMenuVo respSysMenuVo = new RespSysMenuVo();
        SysMenu sysMenu = sysMenuDao.selectByPrimaryKey(menuId);
        BeanUtils.copyProperties(sysMenu, respSysMenuVo);
        return respSysMenuVo;
    }

    @Override
    public int saveSysMenuInfo(ReqSysUser reqSysUser) throws Exception{
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuName(reqSysUser.getMenuName());
        sysMenu.setParentId(reqSysUser.getParentMenuId());
        sysMenu.setPerms(reqSysUser.getPerms());
        sysMenu.setUrl(reqSysUser.getLinkUrl());
        sysMenu.setType(reqSysUser.getMenuType());
        sysMenu.setIcon(reqSysUser.getIconUrl());
        sysMenu.setOrderNum(reqSysUser.getOrderNum());
        sysMenu.setRemark(reqSysUser.getRemark());
        sysMenu.setRouterPath(reqSysUser.getRouterPath());
        sysMenu.setRouterName(reqSysUser.getRouterName());
        if(reqSysUser.getMenuId() != null){
            sysMenu.setMenuId(reqSysUser.getMenuId());
            return sysMenuDao.updateByPrimaryKey(sysMenu);
        }
        return sysMenuDao.insertByExample(sysMenu);
    }

    @Override
    public int removeSysMenuById(Long menuId) throws Exception {
        if(menuId == null){
            return 0;
        }
        return sysMenuDao.deleteByPrimaryKey(menuId);
    }

}
