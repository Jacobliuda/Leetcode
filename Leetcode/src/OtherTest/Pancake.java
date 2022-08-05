package OtherTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/7/19-18:30
 * @description 一次可以吃一个饼或者两个饼，但一次吃两个饼之后的连续两次只能一次吃一个饼，请问有几种方式吃完m个饼？
 */
public class Pancake {
    public static void main(String[] args) {

        /**
         * 如果吃一个饼 后面吃饼无限制
         * 如果吃两个饼 后面只能再吃一个饼两次 那么可以理解为只能一次吃一个或者一次吃四个
         * 转化为 跳一步或者跳四步的爬楼梯问题
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Please print a number: ");
        int m = sc.nextInt();

        int[] step = new int[m+1];
        step[0] = 1;
        step[1] = 1;
        for(int i = 2; i < m+1; i ++){
            step[i] += step[i-1];
            if(i >= 4)
                step[i] += step[i-4];
        }
        System.out.println(step[m]);

    }
}
