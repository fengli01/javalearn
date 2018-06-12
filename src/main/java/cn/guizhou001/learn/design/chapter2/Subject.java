package cn.guizhou001.learn.design.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月07日 15:57
 */
public class Subject {

    List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if(this.state==state){
            return;
        }
        this.state = state;

        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}