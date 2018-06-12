package cn.guizhou001.learn.design.chapter3;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 10:50
 */
public class ReadWritLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);

        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData,"qwertyuiopasdfg").start();
        new WriterWorker(sharedData,"QWERTYUIOPASDFG").start();
    }
}