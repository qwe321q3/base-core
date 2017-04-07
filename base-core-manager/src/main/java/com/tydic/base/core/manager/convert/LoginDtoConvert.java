/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.manager.convert;

import com.tydic.base.core.dal.model.LoginDO;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.request.UserReqDto;
import com.tydic.base.core.service.api.response.LoginResDto;
import com.tydic.base.core.service.api.response.UserResDto;

import java.util.ArrayList;
import java.util.List;



/**
 * 登录DO DTO转换类
 * @author tianshuo
 * @version Id: LoginDtoConvert.java, v 0.1 2016/7/28 0028 16:42 tianshuo Exp $$
 */
public class LoginDtoConvert {

    private LoginDtoConvert() {
    }

    private static LoginDtoConvert loginDtoConvert = new LoginDtoConvert();

    public static LoginDtoConvert getInstance() {
        return loginDtoConvert;
    }


    public List<LoginResDto> converterToLoginResList(List<LoginDO> loginDOList) {
        List<LoginResDto> list = null;
        if (null != loginDOList&& loginDOList.size()>0) {
            list  = new ArrayList<>();
            for(LoginDO loginDO :loginDOList){
                LoginResDto loginResDto = new LoginResDto();
                loginResDto.setId(loginDO.getId());
                loginResDto.setUserStatus(loginDO.getUserStatus());
                loginResDto.setCreatedAt(loginDO.getCreatedAt());
                loginResDto.setCreatedBy(loginDO.getCreatedBy());
                loginResDto.setUserAccount(loginDO.getUserAccount());
                loginResDto.setUserPass(loginDO.getUserPass());
                loginResDto.setUserGroup(loginDO.getUserGroup());
                list.add(loginResDto);
            }
            return list;

        }

        return null;
    }

    public LoginDO converterToLoginDO(LoginReqDto loginReqDto) {
        if (null != loginReqDto) {
            LoginDO loginDO = new LoginDO();

            loginDO.setUserAccount(loginReqDto.getUserName());
            loginDO.setUserPass(loginReqDto.getPassWord());

            return loginDO;
        }

        return null;
    }

    public LoginDO converterUserToLoginDO(UserReqDto userReqDto) {
        if (null != userReqDto) {
            LoginDO loginDO = new LoginDO();

            loginDO.setUserAccount(userReqDto.getUserName());
            return loginDO;
        }

        return null;
    }

    public UserResDto converterToLoginDO(LoginDO loginDO) {
        if (null != loginDO) {
            UserResDto userResDto = new UserResDto();
            userResDto.setUserName(loginDO.getUserAccount());
            userResDto.setPassWord(loginDO.getUserPass());

            return userResDto;
        }

        return null;
    }

}