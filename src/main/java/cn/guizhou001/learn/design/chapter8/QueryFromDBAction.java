package cn.guizhou001.learn.design.chapter8;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 14:36
 */
public class QueryFromDBAction {

    public void execute(){
        try {
            Thread.sleep(1000L);
            String name = "Alex"+Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
//            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}