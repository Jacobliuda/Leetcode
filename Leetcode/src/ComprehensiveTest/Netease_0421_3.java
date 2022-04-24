package ComprehensiveTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/21-19:35
 * @description
 */
public class Netease_0421_3 {
    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;    // 无法到达时距离设为 Integer.MAX_VALUE
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        sc.nextLine();

        // 新建邻接矩阵并初始化
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                matrix[i][j] = MAX;
        }

        // 输入有向边并记录
        int[][] store = new int[e][3];
        for(int i = 0; i < e; i++){
            String[] s = sc.nextLine().split(" ");
            store[i][0] = Integer.parseInt(s[0])-1;
            store[i][1] = Integer.parseInt(s[1])-1;
            store[i][2] = Integer.parseInt(s[2]);
            matrix[store[i][0]][store[i][0]] = store[i][2];
        }

        int start = 0;  // 选择出发点
        int ans = solution(matrix, start, n-1);
        for(int i = 0; i < e; i ++){
            int a = store[i][0];
            int b = store[i][1];
            int c = store[i][2];
            matrix[b][a] = c;
            ans = Math.min(ans, solution(matrix, start, n-1));
            matrix[b][a] = MAX;
        }
        System.out.println(ans!=MAX?ans:-1);
    }

    private static int solution(int[][] weight, int start, int end) {
        boolean[] visit = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] res = new int[weight.length];     // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for(int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for(int j = 0; j < weight.length; j++){
                if(j != start && !visit[j] && res[j] < min){
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;

            for (int j = 0; j < weight.length; j++){
                if (j == p || weight[p][j] == Integer.MAX_VALUE) {  // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]){
                    res[j] = res[p] + weight[p][j];  //更新最短路径
                }
            }
        }

        return res[end];
    }
}

