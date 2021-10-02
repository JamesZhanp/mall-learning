package com.james.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: JamesZhan
 * @create: 2021 - 02 - 15 15:37
 */

@Configuration
@MapperScan("com.james.mall.mbg.mapper")
public class MybatisConfig {
}
