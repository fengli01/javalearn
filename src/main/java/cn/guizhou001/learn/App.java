package cn.guizhou001.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fengli
 * @Description: 启动服务，添加spring-boot-starter-web支持
 * @date 2018年05月30日 16:28
 */
@SpringBootApplication
public class App {

    // 启动服务入口类,默认端口8080，访问地址：ip+端口，本机调用：http://127.0.0.1:8080
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}