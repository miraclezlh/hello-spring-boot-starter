package com.zlh.hello_spring_boot_starter;

import com.zlh.hello_spring_boot_starter.property.GetPropertiesFour;
import com.zlh.hello_spring_boot_starter.property.GetPropertiesOne;
import com.zlh.hello_spring_boot_starter.property.GetPropertiesTwo;
import com.zlh.hello_spring_boot_starter.service.GetPropertyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author 70635
 * 通过@ConfigurationPropertiesScan(包路径)来找到配置类
 */
//@SpringBootApplication(scanBasePackages = "com.zlh.hello_spring_boot_starter")
@SpringBootApplication
@ConfigurationPropertiesScan({"com.zlh.hello.property","com.zlh.hello_spring_boot_starter.property"})
public class HelloSpringBootStarterApplication {

    public static void main(String[] args) {
//      ApplicationContext   applicationContext = SpringApplication.run(HelloSpringBootAutoconfigureApplication.class, args);

        SpringApplication springApplication= new SpringApplication(HelloSpringBootStarterApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        //方式一.@Component+@Value
        GetPropertiesOne getPropertiesOne = applicationContext.getBean(GetPropertiesOne.class);
        //方式一.@Component+@ConfigurationProperties
        GetPropertiesTwo getPropertiesTwo = applicationContext.getBean(GetPropertiesTwo.class);
        //方式三.@ConfigurationProperties+@EnableConfigurationProperties
        GetPropertyService getPropertiesThree = applicationContext.getBean(GetPropertyService.class);
        //方式四.@ConfigurationProperties+@ConfigurationPropertiesScan
        GetPropertiesFour getPropertiesFour = applicationContext.getBean(GetPropertiesFour.class);

        System.out.println(getPropertiesOne.getMessage());
        System.out.println(getPropertiesTwo.getMessage());
        getPropertiesThree.test();
        System.out.println(getPropertiesFour.getEnabled());

        //方式四.从Environment获取
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("sms.enabled"));

    }
}
