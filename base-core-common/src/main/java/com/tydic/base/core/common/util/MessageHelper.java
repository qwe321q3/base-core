
package com.tydic.base.core.common.util;

import java.text.MessageFormat;

/**
 * 消息资源格式化处理，比如占位符的替换等
 * @author tianshuo
 * @version Id: ValidationException.java, v 0.1 2016/7/28 0028 9:47 tianshuo Exp $$
 */
public class MessageHelper {

    /**
     * 格式化含占位符的字符串
     *
     * @param msgTemplate    含占位符的字符串消息模板
     * @param positionValues 消息占位符取代变量，按参数顺序依次取代{0},{1},{2}...等
     * @return 用positionValues替换占位符后的字符串
     * @see MessageFormat#format(String, Object...)
     */
    public static String formatMsg(String msgTemplate, Object... positionValues) {

        try {
            return MessageFormat.format(msgTemplate, positionValues);
        } catch (Exception e) {
            StringBuilder buf = new StringBuilder("资源信息占位符替换异常，占位符参数信息：");
            for (int i = 0; i < positionValues.length; i++) {
                buf.append(" arg[" + i + "]=" + positionValues[i]);
            }
        }
        return msgTemplate;
    }

}
