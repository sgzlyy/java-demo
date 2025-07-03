package designPattern.strategy;

/**
 * @author sby
 * @Title: MD5
 * @Description: MD5
 * @date 2019/1/31 15:42
 */
public class MD5 implements Encryption {

    @Override
    public String encrypt(String password) {
        return "采用MD5加密密码：" + password;
    }
}
