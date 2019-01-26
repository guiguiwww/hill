package com.hanwu.hill.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * MapperScan could also be assigned under App.java.
 * However it could be better under the ConfigClass, which could manage the
 * configuration like the bean.xml and dao mapper.
 */

@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
@MapperScan("com.hanwu.hill.dao")
public class ConfigClass {

}