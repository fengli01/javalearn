package cn.guizhou001.learn.design.chapter8;

/**
 * @author fengli
 * @Description: TODO
 * @date 2018年06月11日 14:54
 */
public class QueryFromHttpAction {
    public void execute() {
//        String cardId = getCardId(context.getName());
//        context.setCardId(cardId);
        String cardId = getCardId(ActionContext.getActionContext().getContext().getName());
        ActionContext.getActionContext().getContext().setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "522158677" + Thread.currentThread().getId();
    }
}