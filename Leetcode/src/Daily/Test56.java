package Daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/8/11-14:26
 * @description
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 */
public class Test56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0]-i2[0]);
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int idx = -1;
        for(int[] interval: intervals){
            if(idx == -1 || ans[idx][1] < interval[0]){
                ans[++idx] = interval;
            }
            else
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
        }
        return Arrays.copyOf(ans, idx+1);
    }

    @Test
    public void test(){
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}