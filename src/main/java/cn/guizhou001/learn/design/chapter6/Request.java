package cn.guizhou001.learn.design.chapter6;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 11:00
 */
public class Request {

    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}