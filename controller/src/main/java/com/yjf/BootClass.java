package com.yjf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Title: BootClass
 * Description: TODO
 *
 * @author yingjf
 * @date 2020/12/11 15:24
 */
@SpringBootApplication(scanBasePackages = "com.yjf")
public class BootClass {
    public static void main(String[] args) {
        SpringApplication.run(BootClass.class, args);
    }
}
