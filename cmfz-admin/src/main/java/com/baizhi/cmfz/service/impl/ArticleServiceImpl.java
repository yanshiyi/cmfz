package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 21:04:18
 **/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDAO articleDAO;

    public void addArticle(Article article) {
        article.setArticleCreatedate(new Date());
        articleDAO.insertArticle(article);
    }
}
