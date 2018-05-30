package cn.guizhou001.learn.chapter1.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author fengli
 * @Description: 简单封装httpclient
 * @date 2018年05月30日 13:43
 */
public class HttpClientUtil {

    // 获取内容
    public static String get(String url) {
        HttpResponse response = doGet(url);

        if (response == null) {
            return "";
        }
        HttpEntity httpEntity = response.getEntity();
        try {
            return EntityUtils.toString(httpEntity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpResponse doGet(String url) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();
        try {
            httpGet.setURI(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}