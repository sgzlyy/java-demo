package algorithm.stack;

/**
 * @author sby
 * @Title: ArrayStack
 * @Description: 基于数组实现的顺序栈
 * @date 2018/10/31 13:43
 */
public class ArrayStack {

    // 数组
    private String[] items;
    // 栈中元素个数
    private int count;
    // 栈的大小
    private int n;

    // 初始化数组，申请一个大小为 n 的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    // 入栈操作
    public boolean push(String item) {

        if (count == n) {
            return false;
        }

        items[count] = item;
        count++;

        return true;
    }

    // 出栈操作
    public String pop() {

        if (count == 0) {
            return null;
        }

        String temp = items[count - 1];
        count--;

        return temp;
    }

}
