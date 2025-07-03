package designPattern.flyweight;

/**
 * @author sby
 * @Title: IgoChessman
 * @Description: TODO
 * @date 2019/1/24 17:33
 */
public abstract class IgoChessman {

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }

    public abstract String getColor();
}
