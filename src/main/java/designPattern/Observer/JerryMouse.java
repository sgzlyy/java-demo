package designPattern.Observer;

/**
 * @author sby
 * @Title: JerryMouse
 * @Description: 观察者实现类
 * @date 2019/1/31 11:41
 */
public class JerryMouse extends Mouse {

    private String name;


    JerryMouse(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "跑了！");
    }
}
