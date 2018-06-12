package cn.guizhou001.learn.design.chapter5;

import java.util.function.Consumer;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 9:24
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            task.call();
            asynFuture.done(task.call());
        }).start();
        return asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task,final Consumer<T> consumer) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}