package cn.guizhou001.learn.design.chapter4;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月08日 11:56
 */
public class UserPersonThread extends Thread
{
    private Person person;

    public UserPersonThread(Person person) {
        this.person = person;
    }


    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" print "+person);
        }
    }
}