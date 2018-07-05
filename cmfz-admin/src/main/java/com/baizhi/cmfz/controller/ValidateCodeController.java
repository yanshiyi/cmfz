package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.ValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 验证码
 * @Author Mr.Yan
 * @Time 2018-07-05 11:01:30
 **/
@Controller
@RequestMapping("/vcode")
public class ValidateCodeController {
    /**
     *@Description
     *@Author Mr.Yan
     *@Time  2018/7/5 11:05
     *@Param [session, response]
     *@Return void
     *@Exception
     **/
    @RequestMapping("/getVcode")
    public void getVcode(HttpSession session, HttpServletResponse response){

        try {
            ValidateCodeUtil validateCodeUtil = new ValidateCodeUtil(80, 25, 4);
            String vcode = validateCodeUtil.getCode();
            session.setAttribute("vcode",vcode);
            validateCodeUtil.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
