package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 菜单实体类
 * @Author Mr.Yan
 * @Time 2018-07-05 14:22:27
 **/
public class Menu implements Serializable{
    private Integer menuId;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private String menuLevel;
    private Integer menuParentId;

    private List<Menu> secondMenu;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuCode, String menuIcon, String menuUrl, String menuLevel, Integer menuParentId, List<Menu> secondMenu) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.secondMenu = secondMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId=" + menuParentId +
                ", secondMenu=" + secondMenu +
                '}';
    }



    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<Menu> getSecondMenu() {
        return secondMenu;
    }

    public void setSecondMenu(List<Menu> secondMenu) {
        this.secondMenu = secondMenu;
    }
}
