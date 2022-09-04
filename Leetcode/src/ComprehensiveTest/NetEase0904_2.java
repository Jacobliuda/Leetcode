package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/4-15:40
 * @description
 */
public class NetEase0904_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        if(2*k-t-1>n || k <= t){
            System.out.println(-1);
            System.exit(0);
        }

        int d = k - t;
        StringBuilder nums = new StringBuilder();

        int i = 0;
        int oneCnt = 0;
        while(i < n){
            if(i <= t){
                nums.append(1);
                oneCnt += 1;
                i++;
            }else{
                if(oneCnt == k)
                    break;
                nums.append(0);
                i++;
                nums.append(1);
                oneCnt++;
                i++;
            }
        }

        while(i < n){
            nums.append(0);
            i++;
        }

        System.out.println(nums.toString());

    }
}
