package Shared;

import org.junit.Test;

import java.util.Arrays;

/**各种排序算法
 * @author Jacob
 * @creator 2022/4/26-15:55
 * @description
 */
public class SortTest {

    // 快速排序
    public void quickSort(int[] arr, int l, int r) {
        if(l >= r)  return;
        int i = l, j = r;
        while(i < j){
            while(i < j && arr[j] >= arr[l])    j--;
            while(i < j && arr[i] <= arr[l])    i++;
            swap(arr, i, j);
        }

        swap(arr, i, l);
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }


    // 堆排序(大根堆)
    public void buildHeap(int[] arr, int heapSize){
        for(int i = heapSize / 2 - 1; i >= 0; i --)
            maxHeapify(arr, i, heapSize);
    }

    // 一次堆的调整
    private void maxHeapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int largest = i;
        if(left <= heapSize - 1 && arr[largest] < arr[left])
            largest = left;
        if(right <= heapSize - 1 && arr[largest] < arr[right])
            largest = right;
        if(largest!=i){
            swap(arr, i, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    // 数组元素的交换
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 快速排序的测试
    @Test
    public void quickSortTest(){
        int[] arr = new int[]{2,2,2,2};
        quickSort(arr, 0, 3);
        int[] ints = Arrays.copyOfRange(arr, 0, 4);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    // 堆排序的测试
    @Test
    public void heapSortTest(){
        int[] arr = new int[]{2,4,1,0,3,5};
        buildHeap(arr, 6);
//        int[] ints = Arrays.copyOfRange(arr, 0, 3);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
