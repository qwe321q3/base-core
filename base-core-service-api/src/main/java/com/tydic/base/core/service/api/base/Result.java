/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.service.api.base;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author tianshuo
 * @version Id: Result.java, v 0.1 2016/7/27 0027 17:01 tianshuo Exp $$
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4767429537969916917L;

    private boolean success;
    private T result;
    private String errorCode;
    private String errorMsg;

    public Result() {
    }

    public Result(T result) {
        this.success = true;
        this.result = result;
    }

    public Result(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public String getErrorCode() {
        return this.errorCode;
    }


    public void setError(String errorCode,String errorMsg){
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
        this.success = false;
    }

    public void setError(String errorCode,String errorMsg,boolean success){
        this.setErrorCode(errorCode);
        this.setErrorMsg(errorMsg);
        this.success = success;
    }


    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 重写tostring 如果返回结果中包含了list，并且list的记录数超过了20，就用[...]来代替
     * @return
     */
    public String toString() {
        String resultTemp = null;
        if(getResult() != null){
            if(getResult() instanceof Collection && ((Collection)getResult()).size() > 20) {
                resultTemp = getResult().getClass().getSimpleName()+"[...]";
            }else{
                resultTemp = this.getResult().toString();
            }
        }
        //jdk1.7中已经对字符串的“+”进行了优化，用“+”拼接字符串会在执行时转为stringBuffer，效率不受影响
        return "Result(result="+resultTemp+",errorCode="+this.getErrorCode()+",errorMsg="+this.getErrorMsg()+",success=" + isSuccess()+")";
    }
}