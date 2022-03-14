package Undefined;

import org.junit.Test;

/**最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @author Jacob
 * @creator 2022/3/14-12:15
 */
public class Test53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 0;
        int acmlt = 0;

        for(int i = 0; i < nums.length; i ++){
            acmlt += nums[i];
            ans = Math.max(ans, acmlt - min);
            min = Math.min(min, acmlt);
        }
        return ans;
    }


}
