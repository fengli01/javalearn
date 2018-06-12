package cn.guizhou001.learn.design.chapter6;

import java.util.LinkedList;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 11:01
 */
public class RequestQueue {

    private final LinkedList<Request> query = new LinkedList<>();

    public Request get() {
        synchronized (query) {
            while (query.size() <= 0) {
                try {
                    query.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Request request = query.removeFirst();
            return request;
        }
    }

    public void put(Request request){
        synchronized (query) {
            query.addLast(request);
            query.notifyAll();
        }
    }
}