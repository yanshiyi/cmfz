package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-12 21:13:07
 **/
public class Permission implements Serializable{
    private Integer perId;
    private String resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    public Permission() {

    }

    public Permission(Integer perId, String resourceName, String resourceTag, String resourceUrl, String permissionTag) {
        this.perId = perId;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "perId=" + perId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getresourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }
}
