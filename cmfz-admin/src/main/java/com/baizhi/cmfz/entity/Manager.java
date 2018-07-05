package com.baizhi.cmfz.entity;

/**
 * @Description 管理员实体类
 * @Author Mr.Yan
 * @Time 2018-07-05 10:42:07
 **/
public class Manager {
    private Integer mgrId;
    private String mgrName;
    private String mgrPwd;
    private String mgrSalt;
    private String mgrStatus;

    public Manager() {

    }

    public Manager(Integer mgrId, String mgrName, String mgrPwd, String mgrSalt, String mgrStatus) {
        this.mgrId = mgrId;
        this.mgrName = mgrName;
        this.mgrPwd = mgrPwd;
        this.mgrSalt = mgrSalt;
        this.mgrStatus = mgrStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgrId=" + mgrId +
                ", mgrName='" + mgrName + '\'' +
                ", mgrPwd='" + mgrPwd + '\'' +
                ", mgrSalt='" + mgrSalt + '\'' +
                ", mgrStatus='" + mgrStatus + '\'' +
                '}';
    }

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getMgrPwd() {
        return mgrPwd;
    }

    public void setMgrPwd(String mgrPwd) {
        this.mgrPwd = mgrPwd;
    }

    public String getMgrSalt() {
        return mgrSalt;
    }

    public void setMgrSalt(String mgrSalt) {
        this.mgrSalt = mgrSalt;
    }

    public String getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrStatus(String mgrStatus) {
        this.mgrStatus = mgrStatus;
    }
}
