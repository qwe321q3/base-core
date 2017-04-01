/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.manager.impl;

import com.tydic.base.core.dal.mapper.LoginMapper;
import com.tydic.base.core.dal.model.LoginDO;
import com.tydic.base.core.manager.LoginManager;
import com.tydic.base.core.manager.convert.LoginDtoConvert;
import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.response.UserResDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tianshuo
 * @version Id: LoginManagerImpl.java, v 0.1 2016/7/28 0028 16:39 tianshuo Exp $$
 */
@Service
public class LoginManagerImpl implements LoginManager{

    @Resource
    private LoginMapper loginMapper;

    /**
     * 登录接口
     * @param loginReqDto 用户账号，密码，验证码
     * @return
     */
    public Result<UserResDto> login(LoginReqDto loginReqDto) {
        LoginDO loginDO = loginMapper.queryByAccountAndPass(LoginDtoConvert.getInstance().converterToLoginDO(loginReqDto));
        Result<UserResDto> result = new Result(LoginDtoConvert.getInstance().converterToLoginDO(loginDO));
        return result;
    }
}