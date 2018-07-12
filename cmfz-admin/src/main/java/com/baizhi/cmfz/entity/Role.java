package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 20:54:00
 **/
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleTag;

    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }
}
