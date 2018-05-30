package cn.guizhou001.learn.chapter1;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author fengli
 * @Description: 请求参数传递，客户端在发送请求的时候，可以自定义参数，头信息，请求参数等，弄完后，扩展HttpClientUtil工具类
 * @date 2018年05月30日 15:54
 */
public class HttpDemo3 {

    /**
     * 发送请求参数
     *
     * @throws Exception
     */
    @Test
    public void sendParams() throws Exception {

        // 设置请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("param1", 1);

        // 封装请求参数
        List<NameValuePair> pairList = new ArrayList<>(params.size());
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            pairList.add(new BasicNameValuePair((String) entry.getKey(), entry.getValue().toString()));
        }

        // 将请求参数加入到请求体中
        URIBuilder URIBuilder = new URIBuilder("http://www.baidu.com");
        URIBuilder.setCharset(Charset.forName("UTF-8"));
        URIBuilder.addParameters(pairList);
        HttpGet httpGet = new HttpGet(URIBuilder.build());

        // 创建连接并发送请求
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpGet);

        // 打印返回结果
        System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

    /**
     * 发送请求体
     *
     * @throws Exception
     */
    @Test
    public void sendHeaders() throws Exception {

        HttpGet httpGet = new HttpGet(new URI("http://www.baidu.com"));

        httpGet.setHeader("token", "1001");
        // 创建连接并发送请求
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpGet);

        // 打印返回结果
        System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
    }
}