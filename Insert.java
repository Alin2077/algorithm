import java.util.Arrays;

/**
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 适合数据量较小或者部分数据已排序的情况
 */
public class Insert {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{40,23,4,6,2,5,50,14,32,48,24};

        doubleCirculation(arr);

        Arrays.asList(arr).forEach(item -> System.out.print(item + "\t"));
    }

    //双循环插入排序
    private static void doubleCirculation(Integer[] arr){

        if(arr == null || arr.length < 2) return;
        int current;
        int j;
        for (int i = 1; i < arr.length; i++) {

            current = arr[i]; //取到当前需要判断的元素
            j = i - 1 ;//从已排序的结尾开始判断

            while (j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;

        }

    }

}
