package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Jacob
 * @creator 2022/9/15-15:53
 * @description
 */
public class GCB0915_1 {

    public int[] findCombination (int n, int[] srcArr) {
        // write code here
        int m = srcArr.length;
        int[][] matrix = new int[m][m];

        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++)
                matrix[i][j] = srcArr[i] * srcArr[j];
        }

        int[] res = new int[n];
        boolean[] used = new boolean[n];
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)  nums[i] = i;

        ArrayList<Integer> track = new ArrayList<>();
        int maxAns = Integer.MIN_VALUE;
        backtrack(matrix, nums, used, track, res, maxAns);

        for(int i = 0; i < res.length; i++){
            res[i] = srcArr[res[i]];
        }
        return res;
    }

    private void backtrack(int[][] matrix, int[] nums, boolean[] used, ArrayList<Integer> track, int[] res, int maxAns){
        if(track.size() == nums.length){
            int ans = get(matrix, track);
            if(ans > maxAns){
                maxAns = ans;
                for(int i = 0; i < track.size(); i++)
                    res[i] = track.get(i);
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(matrix, nums, used, track, res, maxAns);
            used[i] = false;
            track.remove(track.size()-1);
        }

    }


    // 获取每个下标组的乘积和
    private int get(int[][] matrix, ArrayList<Integer> idxes){
        int ans = 0;
        for(int i = 0; i < idxes.size(); i++){
            for(int j = i + 1; j < idxes.size(); j++)
                ans += matrix[idxes.get(i)][idxes.get(j)];
        }
        return ans;

    }

    @Test
    public void test(){
        int n = 3;
        int[] nums = new int[]{1,0,2,-1,-4,-2};
        int[] combination = findCombination(n, nums);
        for (int i : combination) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int i = get(matrix, list);
        System.out.println(i);
    }
}
