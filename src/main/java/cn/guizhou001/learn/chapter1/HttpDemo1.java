package cn.guizhou001.learn.chapter1;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;

/**
 * @author fengli
 * @Description: java学习第一课，http
 * 查询最新的第三方jar：http://search.maven.org/
 * 准备工作：
 * 1.添加单元测试包，junit
 * 2.在pom.xml中添加httpclient.jar
 * @date 2018年05月30日 11:48
 */
public class HttpDemo1 {

    /**
     * httpclient例子
     */
    @Test
    public void testHttpGet() throws Exception {
        // 创建一个httpclient
        HttpClient httpClient = HttpClients.createDefault();

        // 创建httpget请求，请求方式：get，post，delete，put,options,headers等
        // HttpPost，HttpPut,HttpDelete,HttpDelete,HttpHeaders

        HttpGet httpGet = new HttpGet();
        // 设置访问的网站路径
        httpGet.setURI(new URI("http://www.baidu.com"));

        // 得到返回结果
        HttpResponse response = httpClient.execute(httpGet);

        // 取得返回的请求体
        HttpEntity httpEntity = response.getEntity();

        // 打印返回的内容
        System.out.println(EntityUtils.toString(httpEntity, "UTF-8"));
    }
}