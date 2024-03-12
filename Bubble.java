import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bubble {

    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{40,23,4,6,2,5,50,14,32,48,24};

        Integer[] arr = new Integer[100000];

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CountDownLatch countDownLatch = new CountDownLatch(100000);
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            executorService.submit( () -> {
                int i1 = new Random().nextInt(200000);
                arr[finalI] = i1;
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        long start = System.currentTimeMillis();

        doubleCirculation(arr);
//        recursion(arr,arr.length-1);

        long end = System.currentTimeMillis();
        System.out.println("use time is : "+(end-start));

//        Arrays.asList(arr).forEach(item -> System.out.print(item + "\t"));
    }

    //双循环冒泡排序
    private static void doubleCirculation(Integer[] arr){

        int temp;
        boolean flag;

        for(int j = arr.length - 1;j > 0; j--){
            flag = true;
            for (int i = 0; i < j; i++) {
                if(arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = false;
                }
            }

            //优化：设置一个标志位，记录本次循环是否发生交换位置，没有则说明已经排序完了
            if(flag){
                return;
            }

        }

    }

    //递归冒泡排序
    private static void recursion(Integer[] arr,int n){
        int temp = 0;
        if(n > 2){
            for (int i = 0; i < n; i++) {
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            recursion(arr,--n);
        }

    }
}
