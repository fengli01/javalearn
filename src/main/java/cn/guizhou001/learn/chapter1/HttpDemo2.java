package cn.guizhou001.learn.chapter1;

import cn.guizhou001.learn.chapter1.util.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * @author fengli
 * @Description: 第二课，根据httpclient抓取网站数据
 * @date 2018年05月30日 13:36
 */
public class HttpDemo2 {

    /**
     * 抓取网页数据
     * 网址：http://www.gzsjyzx.com（贵州大中专毕业生就业指导中心），最新求职部分
     */
    @Test
    public void testCodeAnalysis() {
        // 地址分析，点击最新求职后，地址为：http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=0&page=0，
        // 下一页page参数加1 ，所以url可以这么定义：
        String url = "http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=&page=";
        int pageNumber = 1;

        // 获取返回的内容
        String content = HttpClientUtil.get(url + pageNumber);

        // 得到网页数据
        System.out.println(content);
    }

    /**
     * 读取网页里面的数据，引入第三方工具包：jsoup.jar
     */
    @Test
    public void testReadData() {
        String url = "http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=0&page=";
        for (int i = 1; i <= 10; i++) {
            url = url + i;

            String content = HttpClientUtil.get(url);
            // 结果转换为html文档
            Document document = Jsoup.parse(content);

            // 获取html中body部分
            Element body = document.body();
            Elements newsCont = body.getElementsByClass("news_cont");

            // 获取最新求职人员
            Element jobHunter = newsCont.get(2);
            Elements hunters = jobHunter.getElementsByClass("art");
            for (int j = 0; j < hunters.size(); j++) {
                Element hunter = hunters.get(j);
                System.out.print(hunter.text() + "\t");
            }
            System.out.println();
        }
    }

}