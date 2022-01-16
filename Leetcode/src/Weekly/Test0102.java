package Weekly;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/1/2-10:34
 */
public class Test0102 {
    //第一题
    public static boolean checkString(String s) {
        int posa = -1, posb = -1;
        int i = 0;
        char[] chars = s.toCharArray();
        while(i<chars.length){
            if(chars[i]=='a'){
                posa = i;
                if(posb!=-1 && posa > posb)
                    return false;
            }

            if(chars[i]=='b')
                posb = i;
            i++;
        }

        if(posb!=-1)
            return posa < posb;
        return true;
    }

    //第二题
    public static int numberOfBeams(String[] bank) {
        int length = bank.length;
        if(length <= 1)
            return 0;
        int[] num = new int[length];
        int ans = 0;
        int j = 0;
        int k = j + 1;
        for(int i = 0; i < length; i++){
            num[i] = count(bank[i]);
        }

        while(k < length){
            while(num[k] == 0){
                k++;
                if(k >= length)
                    return ans;
            }
            ans += num[j] * num[k];
            j = k;
            k++;
        }
        return ans;
    }

    public static int count(String s){
        int cnt = 0;
        int i = 0;
        char[] chars = s.toCharArray();
        while(i < chars.length){
            if(chars[i]=='1')
                cnt++;
            i++;
        }
        return cnt;
    }

//s






    // 建立大根堆
    private static void buildMaxHeap(int[] nums, int heapSize) {
        // 从最后一个非根非叶子结点开始向前调整堆
        for(int i = heapSize / 2 - 1; i >= 0; i--){
            maxHeapify(nums, i, heapSize);
        }
    }

    // 调整堆
    private static void maxHeapify(int[] nums, int i, int heapSize) {
        // l 和 r 分别代表 i 的两个子节点
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;

        // 当 l 未越界而且比 i 更大时，将最大结点赋给 largest
        if(l < heapSize && nums[l] > nums[largest])
            largest = l;

        // 当 r 未越界而且比 i 更大时，将最大结点赋给 largest
        if(r < heapSize && nums[r] > nums[largest])
            largest = r;

        // 如果 i 的子节点比 i 大，则交换两结点的值，并从交换后的结点开始调整
        if(largest != i){
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }

    }

    private static void swap(int[] nums, int i, int largest) {
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
    }



    public static void main(String[] args) {
        String[] s = new String[]{"000","111","000"};
        System.out.println(numberOfBeams(s));

    }
}
