package cn.guizhou001.learn.chapter1.util;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    /**
     * 封装请求
     *
     * @param url
     * @param paramMap
     * @param headers
     * @return
     */
    public static HttpResponse doGet(String url, Map<String, Object> paramMap, Header[] headers) {
        HttpClient httpClient = HttpClients.createDefault();

        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        uriBuilder.setCharset(Charset.forName("UTF-8"));
        if (paramMap != null) {
            List<NameValuePair> pairList = new ArrayList<>(paramMap.size());
            Iterator<Map.Entry<String, Object>> iterator = paramMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                pairList.add(new BasicNameValuePair((String) entry.getKey(), entry.getValue().toString()));
            }
            uriBuilder.addParameters(pairList);
        }

        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(uriBuilder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if (headers != null && headers.length > 0) {
            for (int i = 0; i < headers.length; i++) {
                httpGet.setHeader(headers[i].getName(), headers[i].getValue());
            }
        }

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 没有请求参数的
     *
     * @param url
     * @return
     */
    public static HttpResponse doGet(String url) {
        return doGet(url, null, null);
    }

    /**
     * 带请求参数的
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public static HttpResponse doGet(String url, Map<String, Object> paramsMap) {
        return doGet(url, paramsMap, null);
    }

    /**
     * 带请求体的
     *
     * @param url
     * @param headers
     * @return
     */
    public static HttpResponse doGet(String url, Header[] headers) {
        return doGet(url, null, headers);
    }
}