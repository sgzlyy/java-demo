package algorithm.leetcode;

/**
 * 斐波那契数列
 * 特别指出：第0项是0，第1项是第一个1。
 * 这个数列从第三项开始，每一项都等于前两项之和。
 * @author sby
 * @date 2021/7/30 14:15
 */
public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static long fibonacci(long num) {
        if (num == 1 || num == 0) {
            return num;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
