/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.dal.mapper;

import com.tydic.base.core.dal.model.LoginDO;

/**
 * 用户登录
 * @author tianshuo
 * @version Id: LoginMapper.java, v 0.1 2016/7/28 0028 9:46 tianshuo Exp $$
 */
public interface LoginMapper {

    /**
     * 查询用户信息
     * @param loginDO
     * @return
     */
    int selectOne(LoginDO loginDO);

    /**
     * 查询用户分组
     * 用户权限组。1：管理员组；2：认证审核组；3：风控签约审核组；4：运营签约审核组；5：发布产品发布广告
     */
    LoginDO queryUserGroup(String userName);

    /**
     * 根据用户帐号和密码查询用户信息
     * @param userLoginDO
     * @return
     */
    LoginDO queryByAccountAndPass(LoginDO userLoginDO);

}
