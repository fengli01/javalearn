package cn.guizhou001.learn.design.chapter2;

import java.util.Arrays;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 17:00
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }
}