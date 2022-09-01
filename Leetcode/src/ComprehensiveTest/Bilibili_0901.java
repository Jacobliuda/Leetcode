package ComprehensiveTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/1-19:52
 * @description
 */
public class Bilibili_0901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for(int n = 2; n < 30; n++){
//            int ans = get(n);
//            System.out.println(n + ":" + ans);
//        }

        int ans = get(n);
        System.out.println(n + ":" + ans);
    }

    static int get(int n){
        int ans = 0;
        List<Integer> sons = getSons(n);
        int idx = 0;

        while(idx < sons.size()){
            int son = sons.get(idx);
            while(n % son == 0){
                n /= son;
                ans += son;
            }
            idx ++;
        }

        ans += n == 1 ? 0 : n;
        return ans;
    }

    static List<Integer> getSons(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                list.add(i);
        }

        return list;
    }
}
