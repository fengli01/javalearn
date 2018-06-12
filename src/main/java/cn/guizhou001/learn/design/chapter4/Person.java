package cn.guizhou001.learn.design.chapter4;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 11:52
 */
public final class Person {
    private final String name;
    private final String address;

    public Person(final String name,final String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}