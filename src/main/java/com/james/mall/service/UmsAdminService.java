package com.james.mall.service;

import com.james.mall.mbg.model.UmsAdmin;
import com.james.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 *
 * 后台管理员Service
 * @author: JamesZhan
 * @create: 2021 - 03 - 07 22:48
 */

public interface UmsAdminService {

    /**
     * 根据用户名查找admin
     * @param name
     * @return
     */
    UmsAdmin getAdminByUsername(String name);

    /**
     * 注册
     * @param umsAdmin
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户所有的权限
     * @param adminId 登录admin的Id
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
