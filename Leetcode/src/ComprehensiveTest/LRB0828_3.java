package ComprehensiveTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/28-17:11
 * @description
 */
public class LRB0828_3 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 创建邻接矩阵
        boolean[][] adjoin = new boolean[n][n];
        for(int i = 0; i < n - 1; i++){
            int p = sc.nextInt();
            adjoin[i+1][p-1] = true;
            adjoin[p-1][i+1] = true;
        }

        ArrayList<int[]> match = new ArrayList<>();
        for(int i = 0; i < n; i++){
            dfs(i, n, match);
        }
    }

    private static void dfs(int start, int end, ArrayList<int[]> match){

    }
}
