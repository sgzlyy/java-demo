package designPattern.strategy;

/**
 * @author sby
 * @Title: Encryption
 * @Description: 抽象加密类
 * @date 2019/1/31 15:40
 */
public interface Encryption {
    public String encrypt(String password);
}
