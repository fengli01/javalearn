package cn.guizhou001.learn.design.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 14:12
 */
public class ImmutbleTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public ImmutbleTest(int age, String name) {
        this.age = age;
        this.name = name;
        list = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}