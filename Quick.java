import java.util.Arrays;

/**
 * 快速排序：
 * 选择一个基准值，将比它小的值与数组头部的元素依次交换
 * 递归上述操作
 *
 * 时间复杂度：最好 O(n log n)  最坏 O(n^2)
 * 空间复杂度：最好 O(log n) 最坏 O(n)
 */
public class Quick {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{40,23,4,6,2,5,50,14,32,48,24};

        quickSort(arr,0,arr.length-1);

        Arrays.asList(arr).forEach(item -> System.out.print(item + "\t"));
    }

    private static void quickSort(Integer[] arr,int left,int right){

        if(left < right){
            //获取到中间的基准值
            int pivot = partition(arr,left,right);

            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }

    }

    private static int partition(Integer[] arr,int left,int right){

        //以最右侧的值作为基准值，将小于该值的数都向数组前面交换位置
        int pivot = arr[right];
        int i = left;

        for (int j = i; j < right; j++) {
            if(arr[j] < pivot){
                swap(arr,i,j);
                i++;
            }
        }

        //将基准值交换到所有比它小的数据之后
        swap(arr,right,i);
        return  i;
    }

    private static void swap(Integer[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}