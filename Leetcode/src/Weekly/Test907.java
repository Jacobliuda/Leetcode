package Weekly;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/5/22-21:40
 * @description 907. 子数组的最小值之和
 *
 * 给定一个整数数组 arr，找到 min(b)的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Test907 {
    public int sumSubarrayMins(int[] arr) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int ans = 0;

        for(int i = 0; i < arr.length; i++) {
            while(stack1.size() > 0 && arr[stack1.peek()] > arr[i])
                stack1.pop();
            if(stack1.size() == 0)
                left[i] = -1;
            else
                left[i] = stack1.peek();
            stack1.push(i);
        }

        for(int j = arr.length-1; j > -1; j--) {
            while(stack2.size() > 0 && arr[stack2.peek()] >= arr[j])
                stack2.pop();
            if(stack2.size() == 0)
                right[j] = arr.length;
            else
                right[j] = stack2.peek();
            stack2.push(j);
        }

        for(int k = 0; k < arr.length; k++)
            ans = (ans + arr[k] * (right[k] - k) * (k - left[k])) % 1000000007;

        return ans;
    }

    public int sumSubarrayMinsV2(int[] arr) {
        if(arr.length == 0) return 0;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long ans = 0L;

        for(int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                int cur = stack.pop();
                ans = (ans + (long)(i-cur)*(cur-stack.peek())*arr[cur]) % 1000000007;
            }
            stack.push(i);
        }

        return (int)ans;

    }

    private int getElement(int[] arr, int n, int idx) {
        if(idx == n || idx == -1)
            return -1;
        return arr[idx];
    }

    @Test
    public void test(){
        int[] arr = new int[]{3,2,2,4};
        int i = sumSubarrayMinsV2(arr);
        System.out.println(i);
    }
}
