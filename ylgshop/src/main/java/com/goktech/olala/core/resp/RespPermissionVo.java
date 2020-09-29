package com.goktech.olala.core.resp;

/**
 * 权限视图
 */
public class RespPermissionVo {

    private Long permissionId;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 权限编码
     */
    private String permissionCode;
    /**
     * 权限描述
     */
    private String permissionDescr;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionDescr() {
        return permissionDescr;
    }

    public void setPermissionDescr(String permissionDescr) {
        this.permissionDescr = permissionDescr;
    }
}
