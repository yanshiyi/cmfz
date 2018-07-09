package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 23:07:07
 **/
public class Province implements Serializable{
    private String name;
    private Integer value;

    public Province() {
    }

    public Province(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
