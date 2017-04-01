/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.tydic.base.core.common.validator;

import com.tydic.base.core.common.exception.ValidationException;

/**
 * 校验
 * @author tianshuo
 * @version Id: IValidator.java, v 0.1 2016/7/28 0028 9:46 tianshuo Exp $$
 */
public interface IValidator {

    void validateMutil(Object var1) throws ValidationException;

    void validate(Object var1) throws ValidationException;
}