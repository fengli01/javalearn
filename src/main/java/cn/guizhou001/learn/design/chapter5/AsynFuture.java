package cn.guizhou001.learn.design.chapter5;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 9:20
 */
public class AsynFuture<T> implements Future<T> {

    private volatile boolean done = false;
    T result;

    protected void done(T result) {
        synchronized (this) {
            this.result = result;
            this.done = true;
            notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return result;
    }
}