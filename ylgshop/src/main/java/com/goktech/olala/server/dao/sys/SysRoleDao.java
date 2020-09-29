package com.goktech.olala.server.dao.sys;

import com.goktech.olala.core.req.ReqSysUser;
import com.goktech.olala.core.resp.RespRoleVo;
import com.goktech.olala.server.pojo.sys.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleDao {

    int deleteByPrimaryKey(Long roleId);

    int insertByExample(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    /**
     * 查询角色列表数据
     *
     * @param reqSysUser
     * @return
     */
    @Select("<script>"
            + "SELECT ROLE.ROLE_ID roleId, ROLE.ROLE_NAME roleName, ROLE.DEPT_NAME deptName,ROLE.REMARK description, "
            + "UR.UR_ID urId, UR.USER_ID userId, USER.USER_NAME "
            + "FROM SYS_ROLE ROLE "
            + "LEFT JOIN SYS_USER_ROLE UR ON UR.ROLE_ID = ROLE.ROLE_ID "
            + "LEFT JOIN SYS_USER USER ON USER.USER_ID = UR.USER_ID "
            + "<where>"
            + " 1=1 "
                +"<if test=\"reqSysUser.userId != null \">"
                    +" AND UR.USER_ID = #{reqSysUser.userId}"
                +"</if>"
                +"<if test=\"reqSysUser.roleName != null and reqSysUser.roleName != '' \">"
                    +" AND ROLE.ROLE_NAME LIKE '%${reqSysUser.roleName}%'"
                +"</if>"
            + "</where>"
            + " ORDER BY ROLE.UPDATE_TIME DESC"
            +"</script>")
    List<RespRoleVo> selectByExample(@Param("reqSysUser") ReqSysUser reqSysUser);

    int updateByPrimaryKey(SysRole record);
}