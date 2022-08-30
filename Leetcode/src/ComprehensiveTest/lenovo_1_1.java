package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/16-16:29
 * @description
 */

// 原始方法
public class lenovo_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
//        sc.nextLine();

        int idx = 0;
        while(idx++ < n){
            String s = sc.nextLine();
            boolean flag = fun(s);
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean fun(String s) {
        if(s.length() < 6)
            return false;

        // nums 用来记录字母和数字出现的次数
        int[] nums = new int[2];
        // flag 用来表示上一个字符是否是字母，cnt 用于计数
        boolean flag = false;
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // 如果当前字符是字母
            if(isChar(ch))
                // 字母计数加一
                nums[0] += 1;
            else
                nums[1] += 1;
        }

        if(nums[0] <= nums[1])
            return false;

        for(int i = 4; i < s.length(); i++){
            char ch1 = s.charAt(i-4);
            char ch2 = s.charAt(i-3);
            char ch3 = s.charAt(i-2);
            char ch4 = s.charAt(i-1);
            char ch5 = s.charAt(i);
            if(isChar(ch1) && isChar(ch2) && isChar(ch3) && isChar(ch4) && isChar(ch5))
                return false;
        }

        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1))
                return false;
        }


        return true;

    }

    private static boolean isChar(char ch){
        if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            return true;
        else
            return false;
    }
}

