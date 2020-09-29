package com.goktech.olala.core.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色视图
 */
public class RespRoleVo implements Serializable {

    private Long roleId;
    private String roleName;
    private String deptName;
    private String description;
    private List<RespUserVo> userList = new ArrayList<>();
    private List<RespSysMenuVo> menuVoList = new ArrayList<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RespUserVo> getUserList() {
        return userList;
    }

    public void setUserList(List<RespUserVo> userList) {
        this.userList = userList;
    }

    public List<RespSysMenuVo> getMenuVoList() {
        return menuVoList;
    }

    public void setMenuVoList(List<RespSysMenuVo> menuVoList) {
        this.menuVoList = menuVoList;
    }
}
