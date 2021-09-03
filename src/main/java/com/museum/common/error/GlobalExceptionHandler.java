package com.museum.common.error;

import com.museum.domain.SysError;
import com.museum.service.ISysErrorService;
import com.museum.util.SystemDateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.*;


@ControllerAdvice
public class GlobalExceptionHandler {
    //private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Resource
    private ISysErrorService sysErrorService;

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public  ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        SysError se = new SysError();
        se.setUrl(req.getRequestURI());
        se.setData(e.toString());
        Date daDate = SystemDateUtils.getDaDate();
        se.setCreatetime(daDate);
        sysErrorService.add(se);
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
/* @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        SysError se = new SysError();
        se.setUrl(req.getRequestURI());
        se.setData(e.toString());
        Date daDate = SystemDateUtils.getDaDate();
        se.setCreatetime(daDate);
        sysErrorService.add(se);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }*/

/**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */

/*
   @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        //logger.error("未知异常！原因是:",e);
        SysError se = new SysError();
        se.setUrl(req.getRequestURI());
        se.setData(e.toString());
        Date daDate = SystemDateUtils.getDaDate();
        se.setCreatetime(daDate);
        sysErrorService.add(se);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
*/



}