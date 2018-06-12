package cn.guizhou001.learn.design.chapter2;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 15:57
 */
public abstract class Observer {
    final Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}