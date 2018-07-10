package com.baizhi.cmfz.aspectjaop;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author Mr.Yan
 * @Time 2018-07-10 12:56:03
 **/
@Aspect
public class MyAdvice {
    @Autowired
    private LogService logService;

    @Autowired
    private HttpSession httpSession;

    @Pointcut("((execution(* com.baizhi.cmfz.service.impl.*.add*(..))||execution(* com.baizhi.cmfz.service.impl.*.modify*(..)))&&!execution(* com.baizhi.cmfz.service.impl.LogServiceImpl.*(..)))")
    public void pc(){}

    @Around("pc()")
    public Integer around(ProceedingJoinPoint pjp){
        Log log=new Log();
        log.setLogId(UUID.randomUUID().toString().replace("-",""));
        log.setLogTime(new Date());

        //获取用户名
        Manager manager = (Manager) httpSession.getAttribute("manager");
        String name = manager.getMgrName();
        log.setLogUser(name);

        //获取操作
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        if(method.getName().contains("add")){
            log.setLogAction("添加");
        }else if(method.getName().contains("modify")){
            log.setLogAction("更新");
        }

        //获取类名
        Class<?> aClass = pjp.getTarget().getClass();
        String resource=aClass.getName().substring(aClass.getName().lastIndexOf(".")+1,aClass.getName().length()).replace("ServiceImpl","");
        log.setLogResource(resource);

        //获取参数
        Object[] args = pjp.getArgs();
        String message="";
        for (Object arg : args) {
            message+=arg.toString()+" ";
        }
        log.setLogMessage(message);

        Integer result= 0;
        try {
            result = (Integer) pjp.proceed();
            log.setLogResult("success");
            return result;
        } catch (Throwable throwable) {
            log.setLogResult("error");
            throwable.printStackTrace();
        }finally {
            logService.addLog(log);
        }

        return result;
    }



}
