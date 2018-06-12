package cn.guizhou001.learn.design.chapter6;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 11:16
 */
public class SuspensionClient {
    public static void main(String[] args) {
        final RequestQueue queue = new RequestQueue();

        new ClientThread(queue,"fff").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        serverThread.close();
    }
}