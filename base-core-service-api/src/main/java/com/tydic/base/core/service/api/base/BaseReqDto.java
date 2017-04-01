/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.service.api.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author tianshuo
 * @version Id: BaseReqDto.java, v 0.1 2016/7/27 0027 16:32 tianshuo Exp $$
 */
@Getter
@Setter
public class BaseReqDto implements Serializable{


    private static final long serialVersionUID = -977759783094671169L;

    @NotBlank(message ="日志ID不能为空" )
    private String traceLogId;

    public BaseReqDto() {
    }

    @Override
    public String toString() {
            return "BaseReqDto(traceLogId=" + this.getTraceLogId() + ")";
    }
}