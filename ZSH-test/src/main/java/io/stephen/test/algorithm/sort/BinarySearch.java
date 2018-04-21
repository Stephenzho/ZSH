package io.stephen.test.algorithm.sort;

/**
 * 二分查找
 * @author 10447
 * @since 2018/3/1
 */
public class BinarySearch {
    /**
     * 非递归方法，利用while循环
     * @param arr
     * @param des
     * @return
     */
    public static int binarySearch(int[] arr,int des){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int middle = (low + high) / 2;

            if (arr[middle] == des) {
                return middle;
            } else if (arr[middle] < des) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }


    /**
     * 递归查找
     * @param arr
     * @param des
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] arr,int des,int low,int high){
        int middle = (low + high) / 2;

        if (des < arr[low] || des > arr[high] || low > high) {
            return -1;
        }

        if (arr[middle] < des) {
            return binarySearch(arr, des, middle + 1, high);
        } else {
            if (arr[middle] > des) {
                return binarySearch(arr, des, low, middle - 1);
            } else {
                return middle;
            }
        }
    }
}
