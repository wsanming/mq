package com.goktech.olala.server.dao.sys;


import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespUserVo;
import com.goktech.olala.server.pojo.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserDao {

    int deleteByPrimaryKey(Long userId);

    Integer insertByExample(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    @Select("<script>"
            + "SELECT USER.USER_ID userId, USER.USER_NAME userName, USER.PASSWORD, USER.REAL_NAME realName, USER.SALT, USER.EMAIL, USER.MOBILE, USER.STATUS,"
            + "USER.DEPT_NAME deptName, USER.REMARK, ROLE.ROLE_ID roleId, ROLE.ROLE_NAME roleName, USER.CREATE_TIME createTime,"
            + "USER.CREATE_BY createBy, USER.UPDATE_TIME updateTime, USER.UPDATE_BY updateBy "
            + "FROM SYS_USER USER "
            + "LEFT JOIN SYS_USER_ROLE UR ON UR.USER_ID = USER.USER_ID "
            + "LEFT JOIN SYS_ROLE ROLE ON ROLE.ROLE_ID = UR.ROLE_ID "
            + "<where>"
                + " 1=1 "
                +"<if test=\"reqSysUser.userId != null \">"
                    +" AND USER.USER_ID = #{reqSysUser.userId}"
                +"</if>"
                +"<if test=\"reqSysUser.realName != null and reqSysUser.realName != '' \">"
                    +" AND USER.REAL_NAME LIKE '%${reqSysUser.realName}%'"
                +"</if>"
                +"<if test=\"reqSysUser.userName != null and reqSysUser.userName != '' \">"
                    +" AND USER.USER_NAME LIKE '%${reqSysUser.userName}%'"
                +"</if>"
                +"<if test=\"reqSysUser.password != null and reqSysUser.password != '' \">"
                    +" AND USER.PASSWORD = #{reqSysUser.password}"
                +"</if>"
                +"<if test=\"reqSysUser.roleId != null \">"
                    +" AND UR.ROLE_ID = #{reqSysUser.roleId}"
                +"</if>"
            + "</where>"
            + " ORDER BY USER.UPDATE_TIME DESC"
            +"</script>")
    List<RespUserVo> selectByExample(@Param("reqSysUser") ReqSysUser reqSysUser);

    @Update("UPDATE SYS_USER SET STATUS = #{status} WHERE USER_ID = #{userId}")
    int updateStatusById(@Param("userId") Long userId, @Param("status") Integer status);

    int updateByPrimaryKey(SysUser record);

}