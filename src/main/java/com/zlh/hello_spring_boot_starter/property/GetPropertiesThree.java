package com.zlh.hello_spring_boot_starter.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性类
 * 自定义配置绑定，方式三(@ConfigurationProperties+@EnableConfigurationProperties)
 *
 * @author 70635
 */
@Data
@ConfigurationProperties(prefix = "sms")
public class GetPropertiesThree {
    /**
     * 发送的消息
     */
    private String message;
    /**
     * 是否开启
     */
    private Boolean enabled;
}
