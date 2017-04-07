
package com.tydic.base.core.service.api.request;

import com.tydic.base.core.service.api.base.BaseReqDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author tianshuo
 * @version Id: LoginReqDto.java, v 0.1 2016/7/27 0027 18:01 tianshuo Exp $$
 */
@Getter
@Setter
@ToString(callSuper = true)
public class LoginReqDto extends BaseReqDto{

    private static final long serialVersionUID = 7439572414977443654L;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String passWord;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;
}