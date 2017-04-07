
package com.tydic.base.core.manager.convert;

import com.tydic.base.core.dal.model.LoginDO;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.response.UserResDto;

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

    public LoginDO converterToLoginDO(LoginReqDto loginReqDto) {
        if (null != loginReqDto) {
            LoginDO loginDO = new LoginDO();

            loginDO.setUserAccount(loginReqDto.getUserName());
            loginDO.setUserPass(loginReqDto.getPassWord());

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