/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.service.impl;

import com.tydic.base.core.manager.LoginManager;
import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.facade.LoginService;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.response.UserResDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录接口实现
 * @author tianshuo
 * @version Id: LoginServiceImpl.java, v 0.1 2016/7/27 0027 19:06 tianshuo Exp $$
 */
@Component
public class LoginServiceImpl implements LoginService{

    @Resource
    private LoginManager loginManager;

    /**
     * 登录接口
     * @param loginReqDto 用户账号，密码，验证码
     * @return
     */
    @Override
    public Result<UserResDto> login(LoginReqDto loginReqDto) {
        return loginManager.login(loginReqDto);
    }
}