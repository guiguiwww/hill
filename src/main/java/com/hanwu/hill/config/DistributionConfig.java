package com.hanwu.hill.config;

import java.util.List;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MapperScan could also be assigned under App.java.
 * However it could be better under the DistributionConfig, which could manage the
 * configuration like the bean.xml and dao mapper.
 */

@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
@MapperScan("com.hanwu.hill.dao")
public class DistributionConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DistributionConfig.class);

    @PostConstruct
    public void init() {
        logger.info("Dao mapper and application xml bean init ......");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonConfig.setSerializeFilters(new PascalNameFilter());
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

}