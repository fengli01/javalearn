package cn.guizhou001.learn.design.chapter3;

/**
 * @author fengli
 * @Description: 共享数据
 * @date 2018年06月08日 10:34
 */
public class SharedData {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            this.buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return this.doRead();
        } finally {
            System.out.println("读锁释放了");
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        } finally {
            System.out.println("写锁释放了");
            lock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = c;

        slowly(50);
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++)
            newBuf[i] = buffer[i];

        slowly(50);
        return newBuf;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}