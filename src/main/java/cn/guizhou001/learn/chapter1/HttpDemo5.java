package cn.guizhou001.learn.chapter1;

import cn.guizhou001.learn.chapter1.model.ResumeModel;
import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.*;

/**
 * @author fengli
 * @Description: 抓取简历
 * @date 2018年06月06日 9:32
 */
public class HttpDemo5 {

    /**
     * 登录token
     */
    private static String LOGIN_TOKEN_VALUE = "";

    /**
     * 获取登录token
     *
     * @return
     * @throws Exception
     */
    public static String getLoginToken() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        Map<String, Object> params = new HashMap<>();
        params.put("phone", "13141383186");
        params.put("password", "fl563400");

        List<NameValuePair> pairList = new ArrayList<>(params.size());
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            pairList.add(new BasicNameValuePair((String) entry.getKey(), entry.getValue().toString()));
        }

        HttpPost httpPost = new HttpPost("http://www.gzsjyzx.com/client/login");
        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "UTF-8"));
        HttpResponse response = httpClient.execute(httpPost);
        Header[] headers = response.getAllHeaders();

        for (Header header : headers) {
            HeaderElement[] elements = header.getElements();

            for (HeaderElement element : elements) {
                if ("JSESSIONID".equals(element.getName())) {
                    return element.getValue();
                }
            }
        }
        return "";
    }

    public static String httpGet(String url) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(url));
        if (StringUtils.isEmpty(LOGIN_TOKEN_VALUE)) {
            LOGIN_TOKEN_VALUE = getLoginToken();
        }
        httpGet.setHeader("Cookie", "JSESSIONID=" + LOGIN_TOKEN_VALUE);
        HttpResponse response = httpClient.execute(httpGet);
        return EntityUtils.toString(response.getEntity());
    }

    public static void main(String[] args) throws Exception {

        File file = new File("D:" + File.separator + "dd1.txt");
        OutputStream out = new FileOutputStream(file);
        for (int index = 0; index < 100; index++) {

            String result = httpGet("http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=0&page=" + index);

            Document document = Jsoup.parse(result);
            Elements elements = document.body().getElementsByClass("newscont1");
            elements = elements.get(1).getElementsByClass("art");

            for (Element element : elements) {
                String id = element.getElementsByTag("a").get(0).attr("href").split("/")[3];

                result = httpGet("http://www.gzsjyzx.com/client/vita/" + id);

                Document doc = Jsoup.parse(result);
                elements = doc.body().getElementsByTag("tbody");
                elements = elements.get(0).getElementsByTag("tr");


                ResumeModel resumeModel = new ResumeModel();
                for (int i = 0; i < elements.size(); i++) {
                    // 头像
                    Element element1 = doc.getElementById("showpic");
                    if (i == 0) {
                        String _src = elements.get(i).getElementsByTag("img").attr("src");
                        if (!StringUtils.isEmpty(_src)) {
                            _src = "http://www.gzsjyzx.com" + _src.replace("//", "/");
                        }
                        resumeModel.setAvatarUrl(_src);
                    }
                    if (i == 1) {
                        resumeModel.setName(elements.get(i).getElementsByClass("tdtext").get(0).text());
                    }
                    if (i == 2) {
                        resumeModel.setGender(elements.get(i).getElementsByClass("tdtext").get(0).text());
                    }
                    if (i == 5) {
                        resumeModel.setEmail(elements.get(i).getElementsByClass("tdtext").get(0).text());
//                        System.out.print("电子邮箱：不告诉你\t");
                        resumeModel.setQq(elements.get(i).getElementsByClass("tdtext").get(1).text());
//                        System.out.print("QQ：不告诉你\t");
                    }
                    if (i == 6) {
                        resumeModel.setMobil(
                                elements.get(i).getElementsByClass("tdtext").get(0).text());
//                        System.out.print("手机号：不告诉你\t");
                    }
                    if (i == 3) {
                        resumeModel.setBirthday(elements.get(i).getElementsByClass("tdtext").get(0).text());
                        resumeModel.setSchool(elements.get(i).getElementsByClass("tdtext").get(1).text());
                    }
                    if (i == 4) {
                        resumeModel.setMajor(elements.get(i).getElementsByClass("tdtext").get(0).text());
                    }
                }
                if ("男".equals(resumeModel.getGender()) || StringUtils.isEmpty(resumeModel.getAvatarUrl())) {
                    continue;
                }
                System.out.println(resumeModel);
                out.write(JSON.toJSONBytes(resumeModel));
                out.write("\n".getBytes());
            }
        }
        if (out != null) {
            out.close();
        }
    }
}