package com.tydic.base.core.service.impl;

import javax.annotation.Resource;

import com.tydic.base.core.manager.impl.LoginManagerImpl;
import com.tydic.base.core.service.api.base.PageBeanResDto;
import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.facade.LoginService;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.request.UserReqDto;
import com.tydic.base.core.service.api.response.UserResDto;
import org.springframework.stereotype.Component;



/**
 * 登录接口实现
 * @author tianshuo
 * @version Id: LoginServiceImpl.java, v 0.1 2016/7/27 0027 19:06 tianshuo Exp $$
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginManagerImpl loginManager;

    /**
     * 登录接口
     * @param loginReqDto 用户账号，密码，验证码
     * @return
     */
    @Override
    public Result<UserResDto> login(LoginReqDto loginReqDto) {
        return loginManager.login(loginReqDto);
    }


    /**
     * 分页查询接口
     * @param userReqDto 用户查询条件
     * @return
     */
    public Result<PageBeanResDto> queryUserByPage(UserReqDto userReqDto){
        return loginManager.queryUserByPage(userReqDto);
    }
}