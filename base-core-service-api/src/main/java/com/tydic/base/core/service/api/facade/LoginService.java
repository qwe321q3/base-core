
package com.tydic.base.core.service.api.facade;

import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.response.UserResDto;

/**
 * @author tianshuo
 * @version Id: LoginService.java, v 0.1 2016/7/27 0027 18:21 tianshuo Exp $$
 */
public interface LoginService {

    /**
     * 登录接口
     * @param loginReqDto 用户账号，密码，验证码
     * @return UserResDto 返回用户信息
     */
    Result<UserResDto> login(LoginReqDto loginReqDto);
}