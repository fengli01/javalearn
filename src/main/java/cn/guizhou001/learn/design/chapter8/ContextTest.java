package cn.guizhou001.learn.design.chapter8;

import java.util.stream.IntStream;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 15:01
 */
public class ContextTest {
    public static void main(String[] args) {

        IntStream.range(1, 5).forEach(i -> {
            new Thread(new ExecutionTask()).start();
        });
    }
}