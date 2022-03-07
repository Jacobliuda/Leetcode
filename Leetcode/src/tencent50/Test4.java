package tencent50;

import org.junit.Test;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  算法的时间复杂度应该为 O(log (m+n))
 * @author Jacob
 * @creator 2022/3/7-19:38
 */
public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if((length2 + length1) % 2 == 0)
            return (getKthElement(nums1, nums2, (length2 + length1) / 2) + getKthElement(nums1, nums2, (length2 + length1) / 2 + 1))/2.0;
        else
            return getKthElement(nums1, nums2, (length2 + length1) / 2 + 1);
    }

    // 在两个数组中找到第 k 小的数
    public int getKthElement(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 两个 offset 用来记录遍历到两个数组的位置
        int offset1 = 0;
        int offset2 = 0;

        // 当两个索引都不越界时
        while(offset1 < length1 && offset2 < length2){

            // k = 1时可以直接返回
            if(k == 1)
                return Math.min(nums1[offset1], nums2[offset2]);


            int newOffset1 = Math.min(offset1 + k/2, length1) - 1;
            int newOffset2 = Math.min(offset2 + k/2, length2) - 1;

            if(nums1[newOffset1] <= nums2[newOffset2]){
                k -= (newOffset1 - offset1 + 1);
                offset1 = newOffset1 + 1;
            }else{
                k -= (newOffset2 - offset2 + 1);
                offset2 = newOffset2 + 1;
            }
        }

        if(offset1 >= length1)
            return nums2[offset2 + k - 1];
        else
            return nums1[offset1 + k - 1];

    }

    @Test
    public void test(){
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{6,7,8,9,10};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
