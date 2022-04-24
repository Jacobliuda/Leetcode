package ComprehensiveTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/6-19:30
 * @description
 */
public class HW0406_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int target = sc.nextInt();
        boolean[][] matrix = new boolean[num][num];
        sc.nextLine();

        int idx = 0;
        int cnt = num;
        boolean[] vis = new boolean[num];
        ArrayList<Integer> ans = new ArrayList<>();
        while(cnt-->0){
            String[] split = sc.nextLine().split(",");
            for(int i = 0; i < split.length; i++){
                if(i == 0)  continue;
                int depen = Integer.parseInt(split[i]);
                matrix[depen][idx] = true;
            }
            idx++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        DFS(target, list, vis, matrix);

        System.out.println(1);

    }

    public static void DFS(int v, ArrayList<Integer> list, boolean[] vis, boolean[][] matrix){
//        vis[v] = true;                              //将u设置为已访问
//        for(int u=0; u<n; u++){                       //从u访问可以访问的所有点
//            if(vis[u] == false  &&  matrix[u][v]){  //如果这个点没有被访问过且这个点是能到达的，那么入栈
//                list.add(u);
//                DFS(u, list, vis, matrix);
//            }
//        }
    }
}
