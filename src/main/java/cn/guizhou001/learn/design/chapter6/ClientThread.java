package cn.guizhou001.learn.design.chapter6;

import java.util.Random;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 11:06
 */
public class ClientThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.sendValue = sendValue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Client -> request " + sendValue);
            queue.put(new Request(sendValue+i));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}