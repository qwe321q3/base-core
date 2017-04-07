
package com.tydic.base.core.service.api.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tianshuo
 * @version Id: UserResDto.java, v 0.1 2016/7/27 0027 18:07 tianshuo Exp $$
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserResDto implements Serializable{

    private static final long serialVersionUID = 1837989323353197488L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

}