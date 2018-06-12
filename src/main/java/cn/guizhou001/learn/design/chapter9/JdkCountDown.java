package cn.guizhou001.learn.design.chapter9;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 22:03
 */
public class JdkCountDown {

    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("start");

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ddddd"+Thread.currentThread().getName());
                    countDownLatch.countDown();
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i+"").start();
        }
        countDownLatch.await();
        System.out.println("end");
    }
}