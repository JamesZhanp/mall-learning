package com.james.mall.service;

import com.james.mall.common.api.CommonResult;

/**
 * @author: JamesZhan
 * @create: 2021 - 02 - 24 22:21
 */
public interface UmsMemberSercvice {
    /**
     * 生成验证码
     * @param telephone
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码与手机号码是否匹配
      * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
