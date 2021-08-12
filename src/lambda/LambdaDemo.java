package lambda;

import java.util.Arrays;

/**
 * @author sby
 * @Title: LambdaDemo
 * @Description: TODO
 * @date 2019/2/21 10:04
 */
public class LambdaDemo {


    public static void main(String[] args) {

//        new Thread(() -> {
//            for (int x = 0; x < 100; x++) {
//                System.out.println(Thread.currentThread().getName() + "--" + x);
//            }
//        }).start();

//        Interface1 interface1 = i -> {
//            int j = i * 2;
//            return j;
//        };
//
//        System.out.println(interface1.doubleNum(10));
//
//        System.out.println(interface1.add(100, 1));

//        int[] nums = new int[]{1, 2, 3, 10, 5, 6, 7, 8};
//        int min = IntStream.of(nums).min().getAsInt();
//        System.out.println(min);

//        List<String> proNames = Arrays.asList(new String[]{"Ni", "Hao", "Lambda"});
//        List<String> lowercaseNames3 = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());
//        lowercaseNames3.forEach(System.out::println);

        int[] nums = new int[]{1, 2, 3, 0, 5, 5, 6, 8};
        Arrays.stream(nums).distinct().forEach(System.out::println);
        Arrays.stream(nums).filter(num -> num > 4).forEach(System.out::println);


//        Arrays.stream(nums).distinct().forEach(System.out::println);
//        Arrays.stream(nums).filter(num -> num > 4).forEach(System.out::print);
    }
}
