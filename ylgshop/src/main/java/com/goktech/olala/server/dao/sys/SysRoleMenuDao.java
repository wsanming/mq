package com.goktech.olala.server.dao.sys;

import com.goktech.olala.server.pojo.sys.SysRoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMenuDao {

    int deleteByPrimaryKey(Long rmId);

    int insert(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long rmId);

    @Select("<script>"+
            "SELECT RM.RM_ID rmId, RM.ROLE_ID roleId, RM.MENU_ID menuId FROM SYS_ROLE_MENU RM "+
            "<where>"+
            "1=1"+
                "<if test='roleId != null'>" +
                    " AND RM.ROLE_ID = #{roleId}"+
                "</if>"+
                "<if test='menuId != null'>" +
                    " AND RM.MENU_ID = #{menuId}"+
                "</if>"+
            "</where>"+
            "</script>")
    List<SysRoleMenu> selectByExample(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    int updateByPrimaryKey(SysRoleMenu record);

    @Delete("<script>"+
            "DELETE FROM SYS_ROLE_MENU RM "+
            "<where>"+
                "1=1"+
                "<if test='roleId != null'>" +
                    " AND RM.ROLE_ID = #{roleId}"+
                "</if>"+
                "<if test='menuId != null'>" +
                    " AND RM.MENU_ID = #{menuId}"+
                "</if>"+
            "</where>"+
            "</script>")
    int deleteByExample(@Param("roleId") Long roleId, @Param("menuId") Long menuId);
}