package com.zlh.hello_spring_boot_starter.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 属性类
 * 自定义配置绑定，方式?(@Component+@ConfigurationProperties)
 *
 * @author 70635
 */
@Data
@Component
@ConfigurationProperties(prefix = "sms")
public class GetPropertiesTwo {
    /**
     * 发送的消息
     */
    private String message;
    /**
     * 是否开启
     */
    private boolean enabled;
}
