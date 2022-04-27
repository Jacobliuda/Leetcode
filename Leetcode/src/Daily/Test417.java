package Daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 *
 * @author Jacob
 * @creator 2022/4/27-17:04
 * @description
 */
public class Test417 {

    private int[][] heights;
    private int m, n;
    // 定义四个方向
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
            dfs(m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    ans.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{i, j})));
            }
        }
        return ans;

    }

    public void dfs(int row, int col, boolean[][] ocean) {
        // 若此前已经访问过 则直接返回
        if(ocean[row][col]) return;
        ocean[row][col] = true;
        for (int[] direction : directions) {
            int new_row = row + direction[0];
            int new_col = col + direction[1];
            if (new_row >= 0 && new_row < this.m && new_col >= 0 && new_col < this.n && this.heights[new_row][new_col] >= this.heights[row][col])
                dfs(new_row, new_col, ocean);
            }
        }

    @Test
    public void test(){
        int[][] heights = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> lists = pacificAtlantic(heights);
        for (List<Integer> list : lists) {
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }

}
