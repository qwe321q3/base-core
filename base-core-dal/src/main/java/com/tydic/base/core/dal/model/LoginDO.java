
package com.tydic.base.core.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户登录
 * @author tianshuo
 * @version Id: BaseDO.java, v 0.1 2016/7/28 0028 9:46 tianshuo Exp $$
 */
@Getter
@Setter
@ToString(callSuper = true)
public class LoginDO extends BaseDO {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 登陆密码
     */
    private String userPass;

    /**
     * 状态
     * 1:有效 0:无效
     */
    private String userStatus;

    /**
     *权限组
     *1：管理员组；2：认证审核组；2：风控签约审核组；3：运营签约审核组；4：运营签约审核组；5：发布产品/广告
     */
    private String userGroup;

}
