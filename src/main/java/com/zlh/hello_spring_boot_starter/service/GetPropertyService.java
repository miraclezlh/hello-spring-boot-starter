package com.zlh.hello_spring_boot_starter.service;

import com.zlh.hello_spring_boot_starter.property.GetPropertiesThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @author 70635
 */
@EnableConfigurationProperties({GetPropertiesThree.class})
@Service
public class GetPropertyService {
    @Autowired
    private GetPropertiesThree getPropertiesThree;

    public void test() {
        System.out.println(getPropertiesThree.getEnabled());
    }
}
