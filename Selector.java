import java.util.Arrays;

public class Selector {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{40,23,4,6,2,5,50,14,32,48,24};

//        doubleCirculation(arr,arr.length);
//        recursion(arr,0);
        recursionBetter(arr,0,arr.length-1);

        Arrays.asList(arr).forEach(item -> System.out.print(item + "\t"));
    }

    //双循环选择排序
    private static void doubleCirculation(Integer[] arr,int n){

        if(n < 2) return;

        int temp;
        int tempData;

        for (int i = 0; i < n; i++) {
            temp = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[temp]) temp = j;
            }
            if(temp != i){
                tempData = arr[i];
                arr[i] = arr[temp];
                arr[temp] = tempData;
            }
        }
    }

    //递归选择排序
    private static void recursion(Integer[] arr,int n){
        int temp;
        int tempData;

        if(n < arr.length-1){
            temp = n;
            for (int i = n; i < arr.length; i++) {
                if(arr[i] < arr[temp]){
                    temp = i;
                }
            }
            if(temp != n){
                tempData = arr[n];
                arr[n] = arr[temp];
                arr[temp] = tempData;
            }
            recursion(arr,++n);
        }

    }

    //优化版本选择排序，即每次循环同时选出最大和最小
    private static void recursionBetter(Integer[] arr,int start,int end){
        int temp_min;
        int temp_max;

        if(start < end){
            temp_min = start;
            temp_max = start;
            for (int i = start+1; i <= end; i++) {
                if(arr[i] < arr[temp_min]){
                    temp_min = i;
                }
                if(arr[i] > arr[temp_max]){
                    temp_max = i;
                }
            }

            //先交换最小元素到起始位置
            swap(arr,start,temp_min);

            //如果上面发现最大元素在起始位置，则此时最大元素的下标是temp_min
            if(start == temp_max){
                temp_max = temp_min;
            }

            //交换最大元素到结束位置
            swap(arr,end,temp_max);

            recursionBetter(arr,++start,--end);
        }

    }

    private static void swap(Integer[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
