package com.shiguiwu.admin.util;

/**
 * Created by shiguiwu on 2019/7/6.
 */
public class JsonResult<T> {
    private int code;
    private String message;
    private long total;
    private int pageSize;
    public static int PAGESIZR = 10;
    private T data;

    public JsonResult()
    {
        setCode(ResultCode.SUCCESS);
        setMessage(null);
        setPageSize(PAGESIZR);
    }

    public JsonResult(ResultCode code)
    {
        setCode(code);
        if (ResultCode.SUCCESS != code) {
            setMessage(code.getMsg());
        }
        setPageSize(PAGESIZR);
    }

    public JsonResult(ResultCode code, String message)
    {
        setCode(code);
        setMessage(message);
        setPageSize(PAGESIZR);
    }

    public JsonResult(ResultCode code, String message, T data)
    {
        setCode(code);
        setMessage(message);
        setPageSize(PAGESIZR);
        setData(data);
    }

    public JsonResult(int codeVal, String message, T data)
    {
        setCode(codeVal);
        setMessage(message);
        setPageSize(PAGESIZR);
        setData(data);
    }

    public JsonResult(ResultCode success, T data, long total)
    {
        setCode(success);
        setTotal(total);
        setPageSize(PAGESIZR);
        setData(data);
    }

    public JsonResult(ResultCode success, T data, int pageSize, long total)
    {
        setCode(success);
        setTotal(total);
        setPageSize(pageSize);
        setData(data);
    }

    public int getCode()
    {
        return this.code;
    }

    public void setCode(int codeVal)
    {
        this.code = codeVal;
    }

    public void setCode(ResultCode code)
    {
        this.code = code.getVal();
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public long getTotal()
    {
        return this.total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public static <T> JsonResult<T> buildSuccessResult()
    {
        return new JsonResult<T>(ResultCode.SUCCESS);
    }

    public static <T> JsonResult<T> buildExceptionResult(String messages)
    {
        return new JsonResult<T>(ResultCode.EXCEPTION, messages);
    }

    public static <T> JsonResult<T> buildFailuredResult(ResultCode code, String message)
    {
        return new JsonResult<T>(code, message);
    }

    public static <T> JsonResult<T> buildSuccessResult(T data)
    {
        return new JsonResult<T>(ResultCode.SUCCESS, null, data);
    }

    public static <T> JsonResult<T> buildSuccessResult(T data, long total)
    {
        return new JsonResult<T>(ResultCode.SUCCESS, data, total);
    }

    public static <T> JsonResult<T> buildSuccessResult(T data, int pageSize, long total)
    {
        return new JsonResult<T>(ResultCode.SUCCESS, data, pageSize, total);
    }

    public static <T> JsonResult<T> buildResultWithOutData(JsonResult<?> jsonResult)
    {
        return new JsonResult<T>(jsonResult.getCode(), jsonResult.getMessage(), null);
    }
}
