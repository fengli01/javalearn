package cn.guizhou001.learn.design.chapter5;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 9:19
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
