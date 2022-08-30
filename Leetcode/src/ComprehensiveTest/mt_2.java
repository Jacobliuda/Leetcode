package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/6-10:19
 * @description 小美在做一个实验，这个实验会在纸带上打印出若干个数字，已知该实验所呈现出的正确结果应该是存在某一个分割处k，在k之前打印出的数字都是小于0的，而在k之后的数字应该都是大于0的，那么在k之前如果某一个数据大于等于0，那么我们认为这个数据是异常的，同理，在k之后如果某一个数据小于等于0，那么我们也认为这个数据是异常的。
 *
 *         现在给出小美打印的纸带，且k是未知的，那么请问在最乐观的情况下至少有多少个实验数据是异常的。(显然如果出现0，无论k为哪个时刻，这个0数据都是异常的)
 *
 * 样例输入
 * 5
 * 0 -1 1 1 -1
 * 样例输出
 * 2
 */
public class mt_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        // nums记录原始数据
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // 开始统计以每个位置为分割处的情况下前后各有多少个实验数据是异常的
        int pos = 0, neg = 0;
        int[][] array = new int[2][n+1];

        // 正向统计正负数的情况
        array[0][0] = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                pos += 1;
            else if(nums[i] < 0)
                neg += 1;
            else {
                pos += 1;
                neg += 1;
            }
            array[0][i+1] = pos;

        }

        pos = 0;
        neg = 0;
        // 逆向统计正负数的情况
        array[1][n] = 0;
        for(int i = n-1; i >= 0; i--){
            if(nums[i] > 0)
                pos += 1;
            else if(nums[i] < 0)
                neg += 1;
            else {
                pos += 1;
                neg += 1;
            }
            array[1][i] = neg;
        }

        int ans = 100000;
        for(int i = 0; i < n+1; i++){
            int tmp = array[0][i] + array[1][i];
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);

    }
}
