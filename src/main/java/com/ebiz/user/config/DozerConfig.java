package com.ebiz.user.config;

import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 汶泽
 * @date 2021/8/15-21:56
 */
@Configuration
public class DozerConfig {
//    @Bean
//    public DozerBeanMapper dozerBeanMapper(){
//        List<String> mappingFiles = Arrays.asList("dozer/dozer-mappings.xml");
//        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
//        dozerBeanMapper.setMappingFiles(mappingFiles);
//        return dozerBeanMapper;
//    }

    @Bean
    public DozerBeanMapperFactoryBean dozerMapper(@Value("${dozer.mapping-files}") Resource[] resources) throws IOException {
        DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }
}
