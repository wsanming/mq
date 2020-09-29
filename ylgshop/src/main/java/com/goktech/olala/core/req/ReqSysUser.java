package com.goktech.olala.core.req;

public class ReqSysUser {

    private Long userId;
    private String userName;
    private String realName;
    private Long adminRole;
    private Long roleId;
    private String roleName;
    private Long menuId;
    private Long parentMenuId;
    private String menuName;
    private String password;
    private String email;
    private String mobile;
    private String deptName;
    private String remark;
    //菜单相关属性
    private String linkUrl;
    private String perms;
    private String iconUrl;
    private Integer menuType;
    private Integer orderNum;
    private String routerName;
    private String routerPath;

    //菜单权限
    private Long[] direArr;
    private Long[] menuArr;
    private Long[] permsArr;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Long adminRole) {
        this.adminRole = adminRole;
    }

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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getRouterPath() {
        return routerPath;
    }

    public void setRouterPath(String routerPath) {
        this.routerPath = routerPath;
    }

    public Long[] getDireArr() {
        return direArr;
    }

    public void setDireArr(Long[] direArr) {
        this.direArr = direArr;
    }

    public Long[] getMenuArr() {
        return menuArr;
    }

    public void setMenuArr(Long[] menuArr) {
        this.menuArr = menuArr;
    }

    public Long[] getPermsArr() {
        return permsArr;
    }

    public void setPermsArr(Long[] permsArr) {
        this.permsArr = permsArr;
    }
}
