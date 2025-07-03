package designPattern.strategy;

/**
 * @author sby
 * @Title: User
 * @Description: 用户类
 * @date 2019/1/31 15:45
 */
public class User {

    private String password;
    private Encryption encryption;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Encryption getEncryption() {
        return encryption;
    }

    public void setEncryption(Encryption encryption) {
        this.encryption = encryption;
    }

    public String encrypt() {
        return encryption.encrypt(this.password);
    }
}
