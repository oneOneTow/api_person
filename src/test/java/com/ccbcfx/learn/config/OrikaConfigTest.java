package com.ccbcfx.learn.config;

import com.ccbcfx.learn.remote.dto.ConditionsDto;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import ma.glasnost.orika.MapperFactory;
import org.junit.Test;

public class OrikaConfigTest {
    @Test
      public void a_covert_b(){
          MapperFactory mapperFactory = new OrikaConfig().getFactory();
          ConditionsVo conditionsVo=new ConditionsVo();
          conditionsVo.init();
          ConditionsDto dat=mapperFactory.getMapperFacade().map(conditionsVo.getConditions(), ConditionsDto.class);
          System.out.println(dat.toString());
      }
}
