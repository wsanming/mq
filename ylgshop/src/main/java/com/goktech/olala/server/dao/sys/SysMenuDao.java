package com.goktech.olala.server.dao.sys;

import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespSysMenuVo;
import com.goktech.olala.server.pojo.sys.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysMenuDao {

    /**
     * 根据主键删除菜单
     *
     * @param menuId
     * @return
     */
    int deleteByPrimaryKey(Long menuId);

    /**
     * 新增菜单
     *
     * @param record
     * @return
     */
    int insertByExample(SysMenu record);


    /**
     * 根据主键查询菜单
     *
     * @param menuId
     * @return
     */
    SysMenu selectByPrimaryKey(Long menuId);

    /**
     * 查询菜单列表数据
     *
     * @param reqSysUser
     * @return
     */
    @Select("<script>"
            + "SELECT MENU.MENU_ID menuId, MENU.PARENT_ID parentId,MENU.MENU_NAME menuName, MENU.URL,MENU.PERMS, "
            + "MENU.TYPE,MENU.ICON,MENU.ORDER_NUM orderNum,MENU.ROUTER_NAME routerName,MENU.ROUTER_PATH routerPath, "
            + "MENU.REMARK,IFNULL(PMENU.MENU_NAME,'一级目录') pMenuName "
            + "FROM SYS_MENU MENU "
            + "LEFT JOIN SYS_MENU PMENU ON PMENU.MENU_ID = MENU.PARENT_ID "
            + "<where>"
                +" 1=1 "
                +"<if test=\"reqSysUser.parentMenuId != null \">"
                    +" AND MENU.PARENT_ID = #{reqSysUser.parentMenuId}"
                +"</if>"
                +"<if test=\"reqSysUser.menuType != null \">"
                    +" AND MENU.TYPE = #{reqSysUser.menuType}"
                +"</if>"
                +"<if test=\"reqSysUser.menuName != null and reqSysUser.menuName != '' \">"
                    +" AND MENU.MENU_NAME LIKE '%${reqSysUser.menuName}%'"
                +"</if>"
            + "</where>"
            + " ORDER BY MENU.ORDER_NUM ASC"
            +"</script>")
    List<RespSysMenuVo> selectByExample(@Param("reqSysUser") ReqSysUser reqSysUser);

    /**
     * 查询菜单列表数据
     *
     * @param reqSysUser
     * @return
     */
    @Select("<script>"
            + "SELECT RM.RM_ID rmId, RM.ROLE_ID roleId, RM.MENU_ID menuId, MENU.PARENT_ID parentId, MENU.MENU_NAME menuName "
            + "FROM SYS_ROLE_MENU RM "
            + "LEFT JOIN SYS_MENU MENU ON RM.MENU_ID = MENU.MENU_ID "
            + "LEFT JOIN SYS_MENU PMENU ON PMENU.MENU_ID = MENU.PARENT_ID "
            + "<where>"
                +" 1=1 "
                +"<if test=\"reqSysUser.roleId != null \">"
                    +" AND RM.ROLE_ID = #{reqSysUser.roleId}"
                +"</if>"
                +"<if test=\"reqSysUser.menuId != null \">"
                    +" AND RM.MENU_ID = #{reqSysUser.menuId}"
                +"</if>"
                +"<if test=\"reqSysUser.parentMenuId != null \">"
                    +" AND MENU.PARENT_ID = #{reqSysUser.parentMenuId}"
                +"</if>"
                +"<if test=\"reqSysUser.menuType != null \">"
                    +" AND MENU.TYPE = #{reqSysUser.menuType}"
                +"</if>"
            + "</where>"
            +"</script>")
    List<RespSysMenuVo> selectMenusByRole(@Param("reqSysUser") ReqSysUser reqSysUser);

    /**
     * 根据主键更新保存菜单信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysMenu record);
}