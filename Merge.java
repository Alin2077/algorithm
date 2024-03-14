import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{40,23,4,6,2,5,50,14,32,48,24};

        mergeSort(arr);

        Arrays.asList(arr).forEach(item -> System.out.print(item + "\t"));
    }

    private static void mergeSort(Integer[] arr){
        if(arr == null || arr.length == 1) return;
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(Integer[] arr,int start,int end){

        if( start >= end ){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private static void merge(Integer[] arr,int start,int mid,int end){

        Integer[] temp = new Integer[ end - start + 1 ];//初始化一个数组，大小为传入的范围

        int i = start, j = mid + 1, k = 0;

        while( i <= mid && j <= end ){
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp,0,arr,start,temp.length);

    }

}
