package com.james.mall.controller;

import com.james.mall.common.api.CommonResult;
import com.james.mall.service.UmsMemberSercvice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: JamesZhan
 * @create: 2021 - 02 - 24 22:20
 */

@Api(tags = "UmsMemberController", description = "会员登陆注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberSercvice umsMemberSercvice;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam("telephone") String telephone){
        return umsMemberSercvice.generateAuthCode(telephone);
    }


    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return umsMemberSercvice.verifyAuthCode(telephone, authCode);
    }

}
