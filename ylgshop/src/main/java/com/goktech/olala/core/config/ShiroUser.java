package com.goktech.olala.core.config;

import java.util.Set;

public class ShiroUser {

    private String userName;
    private String password;
    private String roleId;
    private Set<String> roles;
    private CharSequence userStatus;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public CharSequence getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(CharSequence userStatus) {
        this.userStatus = userStatus;
    }
}
