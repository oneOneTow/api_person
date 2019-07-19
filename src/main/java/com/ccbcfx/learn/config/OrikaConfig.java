package com.ccbcfx.learn.config;


import com.ccbcfx.learn.orika.CustomMapperFactory;
import com.ccbcfx.learn.remote.dto.PageStaffDTO;
import com.ccbcfx.learn.vo.response.PagePersonInfoVo;
import ma.glasnost.orika.MapperFactory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrikaConfig {
    @Bean
    public MapperFactory getFactory(){
        MapperFactory mapperFactory= CustomMapperFactory.build();
        mapperFactory.classMap(PageStaffDTO.class, PagePersonInfoVo.class)
                .field("staffDtoList","personList")
                .byDefault()
                .register();
        return mapperFactory;
    }
}