package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespPermissionVo;
import com.goktech.olala.core.resp.RespRoleVo;
import com.goktech.olala.core.resp.RespSysMenuVo;
import com.goktech.olala.core.resp.RespUserVo;
import com.goktech.olala.server.pojo.sys.SysUser;

import java.util.Collection;
import java.util.List;

public interface ISysUserService {

    RespUserVo querySysUserByExample(ReqSysUser reqSysUser) throws Exception;

    List<RespRoleVo> queryRolesByUser(Long userId) throws Exception;

    List<RespPermissionVo> getPermissionByUser(Long userId) throws Exception;

    PageInfo<RespUserVo> queryAllAccountsForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception;

    RespUserVo queryAccountInfoById(Long userId) throws Exception;

    /**
     * 修改用户的状态
     *
     * @param userId
     * @param status
     * @return
     * @throws Exception
     */
    int updateUserStatusById(Long userId, Integer status) throws Exception;

    int saveSysUserInfo(ReqSysUser reqSysUser) throws Exception;

    int removeSysUserById(Long userId) throws Exception;

    /**
     * 分页查询菜单列表数据
     *
     * @param reqSysUser
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<RespSysMenuVo> queryAllMenusForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 未分页查询菜单列表
     *
     * @param reqSysUser
     * @return
     * @throws Exception
     */
    List<RespSysMenuVo> queryAllSysMenus(ReqSysUser reqSysUser) throws Exception;

    List<RespSysMenuVo> querySysMenusByRole(Long roleId) throws Exception;

    RespSysMenuVo querySysMenuInfoById(Long menuId) throws Exception;

    int saveSysMenuInfo(ReqSysUser reqSysUser) throws Exception;

    int removeSysMenuById(Long menuId) throws Exception;

    /**
     * 分页查询角色列表数据
     *
     * @param reqSysUser
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<RespRoleVo> queryAllRolesForPage(ReqSysUser reqSysUser, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 不分页查询角色列表数据
     *
     * @param reqSysUser
     * @return
     * @throws Exception
     */
    List<RespRoleVo> queryAllSysRoles(ReqSysUser reqSysUser) throws Exception;

    RespRoleVo querySysRoleInfoById(Long roleId) throws Exception;

    int saveSysRoleInfo(ReqSysUser reqSysUser) throws Exception;

    int removeSysRoleById(Long roleId) throws Exception;

}
