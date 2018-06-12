package cn.guizhou001.learn.design.chapter4;

import java.util.stream.IntStream;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 11:58
 */
public class ImmutableClinent {
    public static void main(String[] args) {
        Person person = new Person("Asex","GuanSu");

        IntStream.range(0,5).forEach(i->{
            new UserPersonThread(person).start();
        });
    }
}