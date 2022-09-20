package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/19-20:16
 * @description
 */
public class Xunlei0919_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int n = sc.nextInt();
            sc.nextLine();
            String[] ss = new String[n];

            int idx = 0;
            while(idx < n){
                String s = sc.nextLine();
                ss[idx] = s;
                idx++;
            }

            if(fun(ss)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean fun(String[] strs){
        if("".equals(func(strs)))   return true;
        else    return false;
    }

    private static String func(String[] strs){
        String s = strs[0];
        for(String string: strs){
            while(!string.startsWith(s)){
                if(s.length() == 0) return "";
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
