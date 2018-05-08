package com.stotk.mybatisdemo.model;

/**
 *
 */
public class SysRolePrivilege {
    public long roleId;
    public long privilegeId;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
