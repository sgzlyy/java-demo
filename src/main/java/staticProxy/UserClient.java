package staticProxy;

/**
 * @author sby
 * @Title: UserClient
 * @Description:
 * @date 2018/9/26 14:46
 */
public class UserClient {


    public static void main(String[] args) {

        User user = new UserImpl();


        System.out.println(new UserProxy(user));
    }

}
