package Weekly;

/**消除游戏
 * @author Jacob
 * @creator 2022/1/3-13:06
 */
public class Test390 {
    public static int lastRemaining(int n) {
        int head = 1;
        boolean left = true;
        int step = 1;
        while(n > 1){
            if (left || n % 2 == 1) {
                head = head + step;
            }
            n /= 2;
            left = (left==true?false:true);
            step *= 2;
        }

        return head;
    }

    public static void main(String[] args) {
        int n = 24;
        System.out.println(lastRemaining(n));
    }
}
