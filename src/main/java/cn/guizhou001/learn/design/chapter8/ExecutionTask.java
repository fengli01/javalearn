package cn.guizhou001.learn.design.chapter8;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 14:35
 */
public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryAction = new QueryFromDBAction();

    private QueryFromHttpAction httpction = new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context = ActionContext.getActionContext().getContext();
        queryAction.execute();
        System.out.println("the name query successful");
        httpction.execute();
        System.out.println("the card id query successful");

        System.out.println("The Name is "+context.getName()+" and cardId "+context.getCardId());
    }
}