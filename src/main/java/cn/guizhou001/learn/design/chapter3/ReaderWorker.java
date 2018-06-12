package cn.guizhou001.learn.design.chapter3;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 10:42
 */
public class ReaderWorker extends Thread {
    private final SharedData sharedData;

    public ReaderWorker(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = sharedData.read();
                System.out.println(Thread.currentThread().getName() + " ReaderWorker " + String.valueOf(readBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}