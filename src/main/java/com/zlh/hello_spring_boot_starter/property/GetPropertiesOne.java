package com.zlh.hello_spring_boot_starter.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 属性类
 * 自定义配置绑定，方式?(@Component+@Value)
 * 注意：@Value会检查属性字段是否存在，不存在则报错
 * @author 70635
 */
@Data
@Component
public class GetPropertiesOne {
    /**
     * 发送的消息
     */
    @Value("${sms.message:默认值}")
    private String message;
    /**
     * 是否开启
     */
    @Value("${sms.enabled}")
    private boolean enabled;
}
