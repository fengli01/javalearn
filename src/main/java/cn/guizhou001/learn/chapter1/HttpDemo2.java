package cn.guizhou001.learn.chapter1;

import cn.guizhou001.learn.chapter1.util.HttpClientUtil;
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
        // 地址分析，点击最新求职后，地址为：http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=0，
        // 下一页mfsfs参数加1 ，所以url可以这么定义：
        String url = "http://www.gzsjyzx.com/client/student/list?zx=1&mfsfs=";
        int pageNumber = 0;

        // 获取返回的内容
        String content = HttpClientUtil.get(url + pageNumber);

        // 得到网页数据
        System.out.println(content);
    }
}