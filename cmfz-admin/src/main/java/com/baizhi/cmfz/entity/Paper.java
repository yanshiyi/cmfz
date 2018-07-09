package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 19:57:01
 **/
public class Paper implements Serializable{
    private Integer errno;
    private String[] data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
