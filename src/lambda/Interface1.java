package lambda;

/**
 * @author sby
 * @Title: Interface1
 * @Description: TODO
 * @date 2019/2/21 10:09
 */
public interface Interface1 {

    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}
