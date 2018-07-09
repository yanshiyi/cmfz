package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Paper;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 19:34:52
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/upload")
    @ResponseBody
    public Paper uploadFiles(MultipartFile files, HttpSession session){
        String name= UUID.randomUUID().toString().replace("-","")+"."+ FilenameUtils.getExtension(files.getOriginalFilename());
        String realPath = session.getServletContext().getRealPath("/").replace("cmfz-admin","upload")+"/article/";
        try {
            files.transferTo(new File(realPath+name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Paper result = new Paper();
        result.setErrno(0);
        result.setData(new String[]{session.getServletContext().getContextPath()+"/upload/article/"+name});
        return result;
    }

    @RequestMapping("/addArticle")
    @ResponseBody
    public void addArticle(Article article){
        articleService.addArticle(article);
    }
}
