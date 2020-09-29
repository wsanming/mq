package com.goktech.olala.server.dao.sys;

import com.goktech.olala.server.pojo.sys.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleDao {
    int deleteByPrimaryKey(Long urId);

    int insert(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long urId);

    List<SysUserRole> selectAll();

    int updateByPrimaryKey(SysUserRole record);

    @Delete("<script>"+
            "DELETE FROM SYS_USER_ROLE "+
            "<where>"+
            "<if test='roleId != null'>" +
                " AND ROLE_ID = #{roleId}"+
            "</if>"+
            "<if test='userId != null'>" +
                " AND USER_ID = #{userId}"+
            "</if>"+
            "</where>"+
            "</script>")
    int deleteByExample(@Param("userId") Long userId, @Param("roleId") Long roleId);
}