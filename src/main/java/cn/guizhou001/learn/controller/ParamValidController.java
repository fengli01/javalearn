package cn.guizhou001.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fengli
 * @Description: 参数验证控制器
 * @date 2018年05月30日 16:31
 */
@RestController
@RequestMapping("/api") // 访问路径
public class ParamValidController {


    private static Logger LOGGER = LoggerFactory.getLogger(ParamValidController.class);

    /**
     * 定义请求路径：http://127.0.0.1:8080/api/get1
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/get1")
    public Object get1(String name, String age) {
        LOGGER.info("name:" + name + ",age:" + age);
        return "您好，" + name + "，我们获取到您的年龄为" + age;
    }

    @GetMapping("/get2")
    public Object get2(HttpServletRequest request) {


        LOGGER.info("token:" + request.getHeader("token") + ",session:" + request.getHeader("session"));
        return "您好，服务端收到的token：" + request.getHeader("token") + "，session：" + request.getHeader("session");
    }
}