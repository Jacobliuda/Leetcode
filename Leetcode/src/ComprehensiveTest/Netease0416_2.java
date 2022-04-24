package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/16-16:14
 * @description
 */
public class Netease0416_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        boolean build = build(n, k, x);
        if(!build){
            System.out.println(-1);
            System.exit(1);
        }

        int[] nums = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i ++){
            nums[i] = i + 1;
            sum += nums[i];
        }
        int res = x - sum;

        while(res!=0){
            for(int i = 0; i < n; i++){
                if(i<n-1 && nums[i] < nums[i+1]-1){
                    nums[i]++;
                    break;
                }
                if(i==n-1)
                    nums[i]++;
            }
            res--;
        }
        for(int i = 0; i < n; i++)
            System.out.println(nums[i]);




    }

    private static boolean build(int n, int k, int x) {
        if(n < k)
            return false;
        if(x < (1+n)*n/2 || x > n * k - (1+n)*n/2)
            return false;
        return true;
    }
}
