package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/6/26-20:22
 * @description
 */
public class Huatai_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        // n是天数 | k是最大持股数量 | x是初始持股数量
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);

        String[] s1 = sc.nextLine().split(" ");
        int[] stocks = new int[n];
        for(int i = 0; i < n; i++)
            stocks[i] = Integer.parseInt(s1[i]);

        int cash = 0;
        for(int i = 0; i < n-1; i++){
            // 如果后一天的股价高于当天 则在后一天卖出所有股票 收益加上
            if(stocks[i+1] < stocks[i]){
                cash += stocks[i] * x;
                x = 0;
            }else{
                int d = cash / stocks[i];
                if(d + x > k)   d = k - x;

                cash -= d * stocks[i];
                x += d;
            }
        }
        System.out.println("现金：" + cash + ";股票：" + x*stocks[n-1]);

    }
}
