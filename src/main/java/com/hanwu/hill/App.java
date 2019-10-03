package com.hanwu.hill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@MapperScan("com.hanwu.hill.dao")//将项目中对应的mapper类的路径加进来就可以了
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
