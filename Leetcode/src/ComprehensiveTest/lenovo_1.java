package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/16-15:45
 * @description
 */
public class lenovo_1 {
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
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                // 字母计数加一
                nums[0] += 1;

                if(flag){
                    // 判断是否与上一个字符相同
                    // 如果相同 直接返回 false
                    if(ch == s.charAt(i - 1))
                        return false;
                    cnt+=1;

                    if(cnt >= 5)
                        return false;

                }

                flag = true;
            }
            else {
                nums[1] += 1;

                // 遇到数字，将flag置为false，计数器归零
                flag = false;
                cnt = 0;
            }
        }

        if(nums[0] <= nums[1])
            return false;
        return true;

    }
}
