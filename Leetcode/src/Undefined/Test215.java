package Undefined;

import org.junit.Test;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author Jacob
 * @creator 2022/3/12-14:48
 */
public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        bulidHeap(nums, heapSize);
        for (int i = 1; i < k; i++){
            swap(nums, 0, --heapSize);
            maxHeapify(nums, 0, heapSize);

        }
        return nums[0];
    }

    private void bulidHeap(int[] nums, int heapSize) {
        for(int i = heapSize/2 - 1; i >= 0; i--)
            maxHeapify(nums, i, heapSize);
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if(left < heapSize && nums[left] > nums[largest])
            largest = left;
        if(right < heapSize && nums[right] > nums[largest])
            largest = right;
        if(largest != i){
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int largest) {
        int tmp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = tmp;
    }

    @Test
    public void test(){
        int[] nums = new int[]{
                3,2,1,5,6,4
        };

        int kthLargest = findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }
}
