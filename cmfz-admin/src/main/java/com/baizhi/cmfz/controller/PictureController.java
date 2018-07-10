package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-06 09:45:58
 **/
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/getAllPicture")
    @ResponseBody
    public Map<String,Object> getAllPicture(Integer page,Integer rows){
        return pictureService.queryAllPicture(page,rows);
    }

    @RequestMapping("/addPicture")
    @ResponseBody
    public int addPicture(Picture picture, MultipartFile file, HttpSession session){
        String filename=file.getOriginalFilename();
        picture.setPictureName(filename);
        String suffix = filename.substring(filename.lastIndexOf("."), filename.length());
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String name=prefix+suffix;
        picture.setPicturePath(name);

        String realPath=session.getServletContext().getRealPath("/").replace("cmfz-admin","upload")+"/picture/"+name;

        try {
            file.transferTo(new File(realPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pictureService.addPicture(picture);

    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public int modifyPicture(Picture picture){
        return pictureService.modifyPicture(picture);
    }

}
