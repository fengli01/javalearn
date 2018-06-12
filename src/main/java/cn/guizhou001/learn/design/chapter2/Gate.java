package cn.guizhou001.learn.design.chapter2;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 11:13
 */
public class Gate {
    private Integer count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*******BROKEN********" + toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}