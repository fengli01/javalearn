package cn.guizhou001.learn.design.chapter7;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 13:55
 */
public class ThreadLocalSimpleTest {

    private static ThreadLocal threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "0";
        }
    };

    public static void main(String[] args) throws InterruptedException {

      //  threadLocal.set("Alex");
        Thread.sleep(1000);
        System.out.println(threadLocal.get());
    }
}