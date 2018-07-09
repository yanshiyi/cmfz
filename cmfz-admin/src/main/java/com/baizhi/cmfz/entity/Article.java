package com.baizhi.cmfz.entity;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 20:46:11
 **/
public class Article implements Serializable{
    private Integer articleId;
    private String articleName;
    private String articleContent;
    private Date articleCreatedate;
    private Integer guruId;

    public Article() {
    }

    public Article(Integer articleId, String articleName, String articleContent, Date articleCreatedate, Integer guruId) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.articleCreatedate = articleCreatedate;
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleCreatedate=" + articleCreatedate +
                ", guruId=" + guruId +
                '}';
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleCreatedate() {
        return articleCreatedate;
    }

    public void setArticleCreatedate(Date articleCreatedate) {
        this.articleCreatedate = articleCreatedate;
    }

    public Integer getGuruId() {
        return guruId;
    }

    public void setGuruId(Integer guruId) {
        this.guruId = guruId;
    }
}


