package cn.guizhou001.learn.design.chapter4;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 14:16
 */
public class ImmutablePerformance {
    public static void main(String[] args) {
        long startTimestamp = System.currentTimeMillis();
        ImmitableObj immitableObj = new ImmitableObj("Alex");
        for (int i = 0; i < 1000000; i++) {
            System.out.println(immitableObj.toString());
        }
        long endTimestamp = System.currentTimeMillis();

        System.out.println("elapsed time " + (endTimestamp - startTimestamp));
    }
}

class ImmitableObj {
    private final String name;

    public ImmitableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}