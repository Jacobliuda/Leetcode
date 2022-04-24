package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/9-17:05
 * @description
 */
public class Meituan0409_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        boolean[][] adjoin = new boolean[n][n];
        int[] startP = new int[m];
        for(int i = 0; i < m; i++)
            startP[i] = sc.nextInt();
        sc.nextLine();
        int[] endP = new int[m];
        for(int i = 0; i < m; i++){
            endP[i] = sc.nextInt();
            adjoin[startP[i]-1][endP[i]-1] = true;
        }
        sc.nextLine();
        int num = sc.nextInt();
        sc.nextLine();
        while(num-->0){
            String[] s = sc.nextLine().split(" ");
            int a = s[0].charAt(0) - '0', b = s[1].charAt(0) - '0';
            if(dfs(adjoin, a-1, b-1))
                System.out.println("Yes");
            else
                System.out.println("No");
        }


    }

    private static boolean dfs(boolean[][] adjoin, int a, int b) {
        if(adjoin[a][b])    return true;
        boolean ans = false;
        for(int i = 0; i < adjoin[0].length; i++){
            if(adjoin[a][i])
                ans = ans || dfs(adjoin, i, b);
        }
        return ans;
    }


}
