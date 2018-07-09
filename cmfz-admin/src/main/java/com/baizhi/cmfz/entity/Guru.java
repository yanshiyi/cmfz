package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description 上师实体类
 * @Author Mr.Yan
 * @Time 2018-07-08 21:54:30
 **/
public class Guru implements Serializable{

    @Excel(name="编号")
    private Integer guruId;
    @Excel(name="法名")
    private String guruName;
    @Excel(name="头像")
    private String guruPhoto;
    @Excel(name="描述信息")
    private String guruDesc;

    public Guru() {
    }

    public Guru(Integer guruId, String guruName, String guruPhoto, String guruDesc) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPhoto = guruPhoto;
        this.guruDesc = guruDesc;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruDesc='" + guruDesc + '\'' +
                '}';
    }

    public Integer getGuruId() {
        return guruId;
    }

    public void setGuruId(Integer guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruDesc() {
        return guruDesc;
    }

    public void setGuruDesc(String guruDesc) {
        this.guruDesc = guruDesc;
    }
}
