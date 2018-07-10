package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-08 22:24:17
 **/
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/getAllGuru")
    @ResponseBody
    public Map<String,Object> getAllGuru(Integer page,Integer rows){
        return guruService.queryAllGuru(page,rows);
    }

    @RequestMapping("/addGuru")
    @ResponseBody
    public int addGuru(Guru guru, MultipartFile file,HttpSession session){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."), filename.length());
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String name=prefix+suffix;
        guru.setGuruPhoto(name);
        String path=session.getServletContext().getRealPath("/").replace("cmfz-admin","upload")+"/guru/"+name;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guruService.addGuru(guru);
    }

    @RequestMapping("/modifyGuru")
    @ResponseBody
    public int modifyGuru(Guru guru,MultipartFile file,HttpSession session){
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."), filename.length());
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String name=prefix+suffix;
        guru.setGuruPhoto(name);
        String path=session.getServletContext().getRealPath("/").replace("cmfz-admin","upload")+"/guru/"+name;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guruService.modifyGuru(guru);
    }

    @RequestMapping("/addBatch")
    @ResponseBody
    public String addBatch(MultipartFile file){
        ImportParams importParams = new ImportParams();
        List<Guru> gurus = null;
        try {
            gurus = ExcelImportUtil.importExcel(file.getInputStream(), Guru.class, importParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        guruService.addGurus(gurus);
        return null;
    }

    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response){
        try {
            List<Guru> gurus = guruService.queryAll();
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("上师信息", "上市信息表"), Guru.class, gurus);
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");
            String filename=new String("上师信息.xlsx".getBytes(),"iso-8859-1");
            response.setHeader("content-disposition","attachment;filename="+filename);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getGuruByKey")
    @ResponseBody
    public Map<String,Object> getGuruByKey(String name,String value, Integer page, Integer rows){
        return guruService.queryGuruByKey(name,value,page,rows);
    }

    @RequestMapping("/getGuruIdAndName")
    @ResponseBody
    public List<Guru> getGuruIdAndName(){
        return guruService.queryGuruIdAndName();
    }
}
