package com.goktech.olala.core.resp;

import java.util.ArrayList;
import java.util.List;

public class RespSysMenuVo {

    private Long menuId;
    private Long roleId;
    private String roleName;
    private Long rmId;
    private String menuName;
    private Long parentId;
    private String pMenuName;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
    private String remark;
    private String routerName;
    private String routerPath;

    private Long permsId;
    private String permsKey;
    private String permsDesc;

    private List<RespSysMenuVo> childList = new ArrayList<>();

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    public Long getRmId() {
        return rmId;
    }

    public void setRmId(Long rmId) {
        this.rmId = rmId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getpMenuName() {
        return pMenuName;
    }

    public void setpMenuName(String pMenuName) {
        this.pMenuName = pMenuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getPermsId() {
        return permsId;
    }

    public void setPermsId(Long permsId) {
        this.permsId = permsId;
    }

    public String getPermsKey() {
        return permsKey;
    }

    public void setPermsKey(String permsKey) {
        this.permsKey = permsKey;
    }

    public String getPermsDesc() {
        return permsDesc;
    }

    public void setPermsDesc(String permsDesc) {
        this.permsDesc = permsDesc;
    }

    public List<RespSysMenuVo> getChildList() {
        return childList;
    }

    public void setChildList(List<RespSysMenuVo> childList) {
        this.childList = childList;
    }
}
