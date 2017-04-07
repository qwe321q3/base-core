
package com.tydic.base.core.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tydic.base.core.dal.mapper.LoginMapper;
import com.tydic.base.core.dal.model.LoginDO;
import com.tydic.base.core.manager.convert.LoginDtoConvert;
import com.tydic.base.core.service.api.base.PageBeanResDto;
import com.tydic.base.core.service.api.base.Result;
import com.tydic.base.core.service.api.request.LoginReqDto;
import com.tydic.base.core.service.api.request.UserReqDto;
import com.tydic.base.core.service.api.response.UserResDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



/**
 * 分页及登录实例
 * @author tianshuo
 * @version Id: LoginManagerImpl.java, v 0.1 2016/7/28 0028 16:39 tianshuo Exp $$
 */
@Service
public class LoginManagerImpl {

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

    /**
     * 分页查询接口
     * @param userReqDto 用户查询条件
     * @return
     */
    public Result<PageBeanResDto> queryUserByPage(UserReqDto userReqDto){
        PageBeanResDto pageBeanDTO = new PageBeanResDto();

        //setup1 设置当前页数，每页记录数 采用PageHelper插件
        PageHelper.startPage(Integer.parseInt(userReqDto.getCurrentPage()), Integer.parseInt(userReqDto.getPageSize()));
        //setup2 执行查询
        List<LoginDO> list = loginMapper.queryUserGroup(userReqDto.getUserName());
        //setup3 获取分页的详细参数
        PageInfo pageInfo = new PageInfo(list);

        pageBeanDTO.setDataList(LoginDtoConvert.getInstance().converterToLoginResList(list));
        pageBeanDTO.setTotleRows(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        Result<PageBeanResDto> result = new Result(pageBeanDTO);
        return result;
    }
}