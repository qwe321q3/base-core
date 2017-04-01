/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.common.exception;


import com.tydic.base.core.common.enums.ErrorCode;

/**
 * 商服核心Service层异常
 * @author tianshuo
 * @version Id: ValidationException.java, v 0.1 2016/7/28 0028 9:47 tianshuo Exp $$
 */
public class ServiceException extends BaseException {

    public ServiceException(ErrorCode errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public ServiceException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    public ServiceException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public ServiceException(ErrorCode errorCode, String extraMsg) {
        this(errorCode, extraMsg, null);
    }

}
