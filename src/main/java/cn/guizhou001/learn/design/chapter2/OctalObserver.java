package cn.guizhou001.learn.design.chapter2;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 16:13
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}