package designPattern.strategy;

/**
 * @author sby
 * @Title: SHA
 * @Description: SHA
 * @date 2019/1/31 15:44
 */
public class SHA implements Encryption {

    @Override
    public String encrypt(String password) {
        return "采用SHA加密密码：" + password;
    }
}
