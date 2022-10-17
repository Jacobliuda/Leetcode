package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/10/16-20:02
 * @description 将非回文字符串修改为回文字符串 每个字符的修改有代价 求最小代价之和
 */
public class Yidong {
    public static void main(String[] args) {

        // 处理输入
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int[] wgt = new int[n];
        for(int i = 0; i < n; i++)
            wgt[i] = sc.nextInt();

        int cost = 0;
        for(int i = 0; i <= (n-1)/2; i++){
            int j = n - 1 - i;
            if(s.charAt(i)!=s.charAt(j))
                cost += Math.min(wgt[i],wgt[j]);
        }

        System.out.println(cost);
    }
}
