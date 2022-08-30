package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/6-10:11
 * @description 小美开的西点屋举办一周年活动，她准备制作一批礼盒作为对消费者的回馈，每个礼盒中都有三枚西点屋的招牌点心。西点屋共有A和B两种招牌点心，为了让消费者都能品尝到两种点心，因此每个礼盒中都要包含至少一枚A点心和一枚B点心。现在小美的西点屋内共有x枚A点心和y枚B点心，请问小美最多可以制作多少个礼盒。
 *
 * 样例输入
 * 2
 * 44 85
 * 9 49
 * 样例输出
 * 43
 * 9
 */
public class mt_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        //依次对数据进行遍历
        for(int i = 0; i < num; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            int m = Math.min(Math.min(x, y), (x + y)/3);

            while( m * 3 > x + y )
                m--;

            System.out.println(m);

            sc.nextLine();
        }
    }
}
