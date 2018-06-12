package cn.guizhou001.learn.design.chapter2;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 11:19
 */
public class Demo1 {
    public static void main(String[] args) {
        Gate gate = new Gate();
        new Person("zhangsan", "zengzhou", gate).start();
        new Person("liunan", "liuzhou", gate).start();
        new Person("gaoqun", "guiyang", gate).start();
    }
}