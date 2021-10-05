package com.james.mall.service.serviceImpl;

import com.james.mall.common.utils.JwtTokenUtil;
import com.james.mall.dao.UmsAdminRoleRelationDao;
import com.james.mall.mbg.mapper.UmsAdminMapper;
import com.james.mall.mbg.model.UmsAdmin;
import com.james.mall.mbg.model.UmsPermission;
import com.james.mall.service.UmsAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JamesZhanp
 */
@Service
@AllArgsConstructor
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService {
    private final UserDetailsService userDetailsService;

    private final JwtTokenUtil jwtTokenUtil;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final UmsAdminMapper umsAdminMapper;

    private final UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Override
    public UmsAdmin getAdminByUsername(String name) {
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return null;
    }
}
