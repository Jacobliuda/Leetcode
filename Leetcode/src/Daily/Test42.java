package Daily;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/6/5-13:04
 * @description 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Test42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int ans = 0;

        for(int right = 0; right < height.length; right++) {

            // 如果当前的栈不为空 而且 当前的数比栈顶大 要出栈进行计算接雨水的量
            while(!stack.isEmpty() && height[right] > height[stack.peek()]){
                // 取出当前栈顶元素
                int btm = stack.pop();

                // 如果此时栈已空 说明无法构成有效的接雨水区域 直接退出
                if(stack.isEmpty())
                    break;

                // 否则取出左边界
                int left = stack.peek();

                // 计算水的体积 = (左右边界中较小的高度 - 当前的高度) * （宽度差）
                ans += (Math.min(height[left], height[right]) - height[btm]) * (right - left - 1);
            }

            // 第一次入栈 或者 一次计算之后让当前数入栈
            stack.push(right);

        }

        return ans;
    }

    @Test
    public void test() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }
}
