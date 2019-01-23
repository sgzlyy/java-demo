package designPattern.bridge;

/**
 * @author sby
 * @Title: Firm
 * @Description: 厂商
 * @date 2019/1/23 15:29
 */
public abstract class Firm {

    protected Phone phone;

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public abstract void say();
}
