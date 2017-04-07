
package com.tydic.base.core.service.support.exception;

import java.sql.SQLException;

import com.tydic.base.core.common.enums.BizErrorCode;
import com.tydic.base.core.common.exception.ServiceException;
import com.tydic.base.core.common.util.MessageHelper;
import com.tydic.base.core.service.api.base.Result;

/**
 * 统一异常处理
 * @author tianshuo
 * @version Id: LoginServiceImpl.java, v 0.1 2016/7/27 0027 19:06 tianshuo Exp $$
 */
public class ExceptionHandler {
    public static final Result handle(Throwable throwable) {
        Result<Void> result = new Result<Void>();
        if (throwable instanceof ServiceException) {
            ServiceException exception= (ServiceException)throwable;
            result.setError(exception.getErrorCode().getCode(),(formatMsg(exception.getErrorCode().getDesc(),exception.getExtraMsg())));
        }  else if(throwable instanceof SQLException){
            result.setError(BizErrorCode.DATA_BASE_ERROR.getCode(),BizErrorCode.DATA_BASE_ERROR.getDesc());
        }else {
            result.setError(BizErrorCode.SYSTEM_INNER_ERROR.getCode(),BizErrorCode.SYSTEM_INNER_ERROR.getDesc());
        }

        return result;
    }

    /**
     * 错误消息资源格式化处理，比如占位符的替换等
     */
    private static String formatMsg(String msgTemplate, String extraMessage) {
        extraMessage = (null != extraMessage) ? extraMessage : "";
        return MessageHelper.formatMsg(msgTemplate,extraMessage);
    }
}
