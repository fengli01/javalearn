package cn.guizhou001.learn.design.chapter5;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 9:33
 */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {

        FutureService futureService = new FutureService();

        FutureTask futureTask = new FutureTask() {
            @Override
            public Object call() {
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "FINISH";
            }
        };
        Future future = futureService.submit(futureTask,System.out::println);
        System.out.println("===========");
        System.out.println(" do other thing.");
        Thread.sleep(1000);
        System.out.println("===========");
    }
}