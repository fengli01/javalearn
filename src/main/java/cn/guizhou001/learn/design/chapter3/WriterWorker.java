package cn.guizhou001.learn.design.chapter3;

import java.util.Random;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 10:45
 */
public class WriterWorker extends Thread {
    private static final Random random = new Random(System.currentTimeMillis());
    private final SharedData sharedData;
    private final String filler;
    private int index = 0;

    public WriterWorker(SharedData sharedData, String filler) {
        this.sharedData = sharedData;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                sharedData.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}