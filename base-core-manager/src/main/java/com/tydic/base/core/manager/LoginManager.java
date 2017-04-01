/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.manager;

import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.response.UserResDto;

/**
 * @author tianshuo
 * @version Id: LoginManager.java, v 0.1 2016/7/28 0028 16:36 tianshuo Exp $$
 */
public interface LoginManager {

    /**
     * 登录接口
     * @param loginReqDto 用户账号，密码，验证码
     * @return
     */
    Result<UserResDto> login(LoginReqDto loginReqDto);
}