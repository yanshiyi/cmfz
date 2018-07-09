package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Province;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-09 23:03:07
 **/
@Controller
@RequestMapping("/analysis")
public class AnalysisController {

    @RequestMapping("/getAnalysis1")
    @ResponseBody
    public List<Province> getAnalysis1(){
        List<Province> list = new ArrayList<Province>();
        Random random=new Random();
        list.add(new Province("北京",random.nextInt(10000)));
        list.add(new Province("天津",random.nextInt(10000)));
        list.add(new Province("河北",random.nextInt(10000)));
        list.add(new Province("山西",random.nextInt(10000)));
        list.add(new Province("内蒙古",random.nextInt(10000)));
        list.add(new Province("辽宁",random.nextInt(10000)));
        list.add(new Province("吉林",random.nextInt(10000)));
        list.add(new Province("黑龙江",random.nextInt(10000)));
        list.add(new Province("上海",random.nextInt(10000)));
        list.add(new Province("江苏",random.nextInt(10000)));
        return list;
    }


    @RequestMapping("/getAnalysis2")
    @ResponseBody
    public List<Province> getAnalysis2(){
        List<Province> list = new ArrayList<Province>();
        Random random=new Random();
        list.add(new Province("北京",random.nextInt(10000)));
        list.add(new Province("贵州",random.nextInt(10000)));
        list.add(new Province("福建",random.nextInt(10000)));
        list.add(new Province("山西",random.nextInt(10000)));
        list.add(new Province("内蒙古",random.nextInt(10000)));
        list.add(new Province("辽宁",random.nextInt(10000)));
        list.add(new Province("浙江",random.nextInt(10000)));
        list.add(new Province("黑龙江",random.nextInt(10000)));
        list.add(new Province("上海",random.nextInt(10000)));
        list.add(new Province("重庆",random.nextInt(10000)));
        return list;
    }
}
