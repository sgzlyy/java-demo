import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * @author sby
 * @date 2024/7/20 11:58
 */
public class HeapOutMemory {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        while (true) {
            list.add(new User());
        }
    }

    static class User {
        private String name = "demo";

        public User() {
        }
    }
}
