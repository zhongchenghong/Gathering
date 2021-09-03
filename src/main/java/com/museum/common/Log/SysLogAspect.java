package com.museum.common.Log;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.ResourceLog;
import com.museum.domain.Syslog;
import com.museum.service.IAccountService;
import com.museum.service.IResourceLogService;
import com.museum.service.ISyslogService;
import com.museum.util.HttpContextUtil;
import com.museum.util.IpUtils;
import com.museum.util.SystemDateUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.TimeZone;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Resource
    private ISyslogService syslogService;

    @Resource
    private IResourceLogService resourceLogService;

    @Resource
    private IAccountService accountService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.museum.common.Log.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        String value=null;
        String params = null;
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String token=request.getHeader("token");
        String name=JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        //获取用户名
        Account acc=accountService.getOne(queryWrapper);
        if(acc!=null){
        //保存日志
        Syslog sysLog = new Syslog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();


        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        if(args.length>1){
            for(int i=0;i>args.length;i++){
                params = args[i]+params;
            }
        }else{
            params = JSON.toJSONString(args);
        }
        //将参数所在的数组转换成json
        sysLog.setParams(params);
        Date daDate = SystemDateUtils.getDaDate();
        sysLog.setCreateDate(daDate);
        sysLog.setUsername(acc.getUserName());
        //获取用户ip地址
        sysLog.setIp(IpUtils.getIpAddress(request));
        //调用service保存SysLog实体类到数据库
        syslogService.save(sysLog);


          //统一发布上传下载日志
        if("com.museum.controller.ResourcesController.savafile".equals(className + "." + methodName)
        ||"com.museum.controller.ResourcesController.findById".equals(className + "." + methodName)
        ||"com.museum.controller.ScreenResourcesController.savafile".equals(className + "." + methodName)
        ||"com.museum.controller..ScreenContentController.add".equals(className + "." + methodName)){
            ResourceLog rl= new ResourceLog();
            rl.setOperation(value);
            rl.setMethod(methodName);
            rl.setParams(params);
            rl.setIp(IpUtils.getIpAddress(request));
            String  createDate = SystemDateUtils.getStrDate();
            rl.setCreateDate(createDate);
            rl.setUsername(acc.getUserName());
            resourceLogService.save(rl);
        }

        }
    }

}