package cn.guizhou001.learn.design.chapter3;

/**
 * @author fengli
 * @Description: 读写锁
 * @date 2018年06月08日 10:20
 */
public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWriter = true;
    /**
     * 获取读锁
     *
     * @throws InterruptedException
     */
    public synchronized void readLock() throws InterruptedException {
        this.waitingReaders++;
        try {
            if (writingWriters > 0 ) {
                this.wait();
            }

            this.readingReaders++;
        } finally {
            this.waitingReaders--;
        }
    }

    /**
     * 释放读锁
     */
    public synchronized void readUnLock() {
        this.readingReaders--;
        notifyAll();
    }

    /**
     * 获取写锁
     *
     * @throws InterruptedException
     */
    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            if (writingWriters > 0 || readingReaders > 0) {
                this.wait();
            }

            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    /**
     * 释放写锁
     */
    public synchronized void writeUnLock() {
        this.writingWriters--;
        notifyAll();
    }
}