package cn.guizhou001.learn.design.chapter9;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 22:25
 */
public class SimpleCountDownLatch {

    private final Integer total;

    private int count = 0;
    public SimpleCountDownLatch(Integer total) {
        this.total = total;
    }

    public void countDown(){
        synchronized (this){
            this.count++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (count<total){
                this.wait();
            }
        }
    }
}