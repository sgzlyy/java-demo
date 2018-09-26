package staticProxy;

/**
 * @author sby
 * @Title: UserProxy
 * @Description: 代理类
 * @date 2018/9/26 14:42
 */
public class UserProxy implements User {

    private User user;

    UserProxy(User user) {
        this.user = user;
    }


    @Override
    public String getName() {

        String pString = "代理类执行：";
        return pString + user.getName();
    }
}
