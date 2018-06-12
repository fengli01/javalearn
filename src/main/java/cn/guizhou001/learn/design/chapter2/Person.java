package cn.guizhou001.learn.design.chapter2;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 11:14
 */
public class Person extends Thread {
    private String name;
    private String address;

    private Gate gate;

    public Person(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(this.name + " BEGIN");
        while (true) {
            this.gate.pass(this.name, this.address);
        }
    }
}