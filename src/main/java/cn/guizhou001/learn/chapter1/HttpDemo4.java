package cn.guizhou001.learn.chapter1;

import cn.guizhou001.learn.chapter1.util.HttpClientUtil;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengli
 * @Description: 自定义api接口，验证请求参数信息。启动服务参考App.java 和 ParamValidController.java两个文件
 * @date 2018年05月30日 16:25
 */
public class HttpDemo4 {


    /**
     * 发送参数
     */
    @Test
    public void testParam1() {
        String url = "http://127.0.0.1:8080/api/get1";

        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("name", "张三");
        paramsMap.put("age", 30);

        // 发送请求
        HttpResponse response = HttpClientUtil.doGet(url, paramsMap);

        // 打印结果
        try {
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送头信息
     */
    @Test
    public void testParam2() {
        String url = "http://127.0.0.1:8080/api/get2";

        Header[] headers = new Header[2];

        Header header1 = new BasicHeader("token", "123456");
        Header header2 = new BasicHeader("session", "654321");
        headers[0] = header1;
        headers[1] = header2;

        // 发送请求
        HttpResponse response = HttpClientUtil.doGet(url, headers);

        // 打印结果
        try {
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}