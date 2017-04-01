/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.common.exception;


import com.tydic.base.core.common.enums.ErrorCode;
import com.tydic.base.core.common.util.MessageHelper;

/**
 * 商服核心基础异常
 * @author tianshuo
 * @version Id: ValidationException.java, v 0.1 2016/7/28 0028 9:47 tianshuo Exp $$
 */
public abstract class BaseException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = 1279879878978686L;

    /**
     * 错误码信息
     */
    private ErrorCode errorCode;

    /**
     * 除了错误码本身描述的提示信息外，额外补充的信息
     */
    private String extraMsg;

    /**
     * 错误信息模板
     */
    private final static String MSG_TEMPLATE = "错误码:{0}, 描述:{1}, 异常信息:{2}";

    /**
     * 提供异常码和异常源构造异常
     *
     * @param errorCode 异常码
     * @param cause     异常原因
     * @throws NullPointerException <code>errorCode</code>不能为空，否则抛出异常
     * @see ErrorCode
     */
    public BaseException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    /**
     * 设置除了错误码本身描述的提示信息外，额外补充的信息
     * <p/>
     * 当错误码本身只是比较模糊的提示下，可以额外补充其他信息
     *
     * @param extraMsg 额外补充的信息
     */
    public BaseException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(getMessage(errorCode, extraMsg), cause);
        this.errorCode = errorCode;
        this.extraMsg = extraMsg;
    }

    /**
     * 提供异常码构造异常
     *
     * @param errorCode 异常码异常码 *
     * @throws NullPointerException <code>errorCode</code>不能为空，否则抛出异常
     * @see ErrorCode
     */
    public BaseException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    /**
     * 设置除了错误码本身描述的提示信息外，额外补充的信息
     * <p/>
     * 当错误码本身只是比较模糊的提示下，可以额外补充其他信息
     *
     * @param extraMsg 额外补充的信息
     */
    public BaseException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }

    /**
     * 获得异常码信息
     *
     * @return ErrorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * 返回除了错误码本身描述的提示信息外，额外补充的信息
     *
     * @return the extraMsg
     */
    public String getExtraMsg() {
        return extraMsg;
    }

    /**
     * 设置除了错误码本身描述的提示信息外，额外补充的信息
     *
     * @param extraMsg the extraMsg to set
     */
    public void setExtraMsg(String extraMsg) {
        this.extraMsg = extraMsg;
    }

    private static String getMessage(ErrorCode errorCode, String extraMessage) {
        extraMessage = (null != extraMessage) ? extraMessage : "";
        return MessageHelper.formatMsg(MSG_TEMPLATE, errorCode.getCode(), errorCode.getDesc(), extraMessage);
    }

}
