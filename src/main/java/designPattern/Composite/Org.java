package designPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sby
 * @Title: Org
 * @Description: TODO
 * @date 2019/1/23 17:05
 */
public class Org extends AbstractModel {

    private String name;
    private List<AbstractModel> list = new ArrayList<>();

    Org(String name) {
        this.name = name;
    }

    public void add(AbstractModel model) {
        list.add(model);
    }

    public void remove(AbstractModel model) {
        list.remove(model);
    }

    public AbstractModel getChild(int i) {
        return list.get(i);
    }

    @Override
    public void sendMsg() {

        System.out.println("--------发送信息给《" + name + "》开始---------");

        for (AbstractModel abstractModel : list) {
            abstractModel.sendMsg();
        }

        System.out.println("--------发送信息给《" + name + "》结束---------");
    }
}
