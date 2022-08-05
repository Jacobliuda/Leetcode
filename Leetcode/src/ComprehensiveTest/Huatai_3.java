package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/6/26-19:22
 * @description
 */
public class Huatai_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[][] array = new boolean[num][num];
        sc.nextLine();
        int cnt = 1;
        while(cnt++ < num){
            String[] s = sc.nextLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            array[start-1][end-1] = true;
            array[end-1][start-1] = true;
        }

        int[] ans = new int[1];
        for(int i = 0; i < num; i++){
            dfs(i, array, num, i, ans);
        }
        System.out.println(ans[0]);
    }

    public static void dfs(int start, boolean[][] array, int num, int idx, int[] ans){
        for(int end = 0; end < num; end++){
            if(array[start][end]){
                array[start][end] = false;
                array[end][start] = false;
                dfs(end, array, num, idx, ans);
                array[start][end] = true;
                array[end][start] = true;
                ans[0] += Math.max(start, end) + 1;
                ans[0] %= 1000000007;
            }
        }
    }
}
