package com.museum.common;

public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result error(Integer code, String msg,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result successPicture(int Errno, Object object) {
        Result result = new Result();
        result.setErrno(Errno);
        result.setData(object);
        return result;
    }

    public static Result errorPicture(Integer Errno,Object data) {
        Result result = new Result();
        result.setErrno(Errno);
        result.setData(data);
        return result;
    }

}
