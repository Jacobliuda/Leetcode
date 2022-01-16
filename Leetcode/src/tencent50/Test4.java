package tencent50;

/**给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1和 nums2。请你找出并返回这两个正序数组的 中位数 。

 算法的时间复杂度应该为 O(log (m+n))

 * @author Jacob
 * @creator 2022/1/4-14:09
 */
public class Test4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if(length % 2 == 1){
            int k = length / 2;
            return getKthElement(nums1, nums2, k + 1);
        }else{
            int k1 = length / 2 - 1, k2 = length / 2;
            return (getKthElement(nums1, nums2, k1) + getKthElement(nums1, nums2, k2)) / 2.0;
        }

    }

    // 获取两个数组中第 k 小的数
    public static int getKthElement(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int off1 = 0, off2 = 0;

        while(true){
            if(off1 == length1)
                return nums1[off2 + k - 1];
            if(off2 == length2)
                return nums2[off1 + k - 1];
            if(k == 1)
                return Math.min(nums1[off1], nums2[off2]);

            int half = k / 2;
            int newOff1 = Math.min(off1 + half, length1) - 1;
            int newOff2 = Math.min(off2 + half, length2) - 1;
            int pivot1 = nums1[newOff1], pivot2 = nums2[newOff2];
            if(pivot1 <= pivot2){
                k -= (newOff1 - off1 + 1);
                off1 = newOff1 + 1;
            }else{
                k -= (newOff2 - off2 + 1);
                off2 = newOff2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
