package thread.ForkAndJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 利用fork和join做连续数字相加的计算
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10; //阈值

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;

        //如果拆分的任务足够小，就开始计算任务
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {

            // 如果任务大于阈值，就分裂成两个任务
            int middle = (start + end) / 2;

            CountTask left = new CountTask(start, middle);
            CountTask right = new CountTask(middle + 1, end);

            // 执行任务
            left.fork();
            right.fork();

            //等待子任务执行完，并得到结果集
            int leftResult = left.join();
            int rightResult = right.join();

            // 合并子任务
            sum = leftResult + rightResult;

        }


        return sum;
    }


    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 15);

        Future<Integer> result = forkJoinPool.submit(countTask);


        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
