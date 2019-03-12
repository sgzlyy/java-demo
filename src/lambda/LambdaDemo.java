package lambda;

/**
 * @author sby
 * @Title: LambdaDemo
 * @Description: TODO
 * @date 2019/2/21 10:04
 */
public class LambdaDemo {


    public static void main(String[] args) {

//        new Thread(() -> System.out.println("111")).start();

        Interface1 interface1 = i -> {
            int j = i * 2;
            return j;
        };

        System.out.println(interface1.doubleNum(10));

        System.out.println(interface1.add(100, 1));

//        int[] nums = new int[]{1, 2, 3, 0, 5, 6, 7, 8};
//        int min = IntStream.of(nums).min().getAsInt();
//        System.out.println(min);
    }
}
