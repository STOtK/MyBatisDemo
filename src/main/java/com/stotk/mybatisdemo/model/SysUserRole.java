package com.stotk.mybatisdemo.model;

/**
 *
 */
public class SysUserRole {
    public long userId;
    public long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
