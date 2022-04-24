package ComprehensiveTest;

/**
 * @author Jacob
 * @creator 2022/4/7-20:34
 * @description
 */
import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ans = new int[80];
        ans[0] = 1;
        ans[1] = 2;
        for(int i = 2; i < 80; i++)
            ans[i] = ans[i-1] + ans[i-2];
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(ans[x-1]);
        }
    }

    public static int getWays(int x){
        if(x==1)    return 1;
        if(x==2)    return 2;
        return getWays(x-1)+getWays(x-2);
    }
}
