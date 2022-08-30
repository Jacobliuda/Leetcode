package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/8/30-21:50
 * @description
 */
public class Test670 {
    public int maximumSwap(int num) {

        // 记录每个数字最后出现的位置
        char[] nums = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        for(int i = 0; i < nums.length; i++)
            last[nums[i]-'0'] = i;

        // 从前向后扫描并交换
        for(int i = 0; i < nums.length; i++){
            for(int d = 9; d > nums[i] - '0'; d--){
                if(last[d] > i){
                    swap(nums, i, last[d]);
                    return Integer.parseInt(new String(nums));
                }
            }
        }
        return num;
}

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

    @Test
    public void test(){
        int num = 10;
        System.out.println(maximumSwap(num));
    }
}
