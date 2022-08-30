package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/28-10:30
 * @description 代码自动补全
 * 输入
 * 8
 * select
 * from
 * where
 * limit
 * origin_log_db
 * event_log_table
 * user_id
 * from_mobile
 * f
 *
 * 输出
 * from
 * from_mobile
 */
public class ByteDance0828_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        // 存储关键字
        String[] strs = new String[n];
        int idx = 0;
        while(idx < n){
            strs[idx] = sc.nextLine();
            idx++;
        }

        Arrays.sort(strs);

        // 拿到需要进行匹配的字符开始匹配
        ArrayList<String> match = new ArrayList<>();
        String s = sc.nextLine();

        int i = 0;
        while(i < n && !strs[i].startsWith(s))
            i++;

        while(i < n && strs[i].startsWith(s)){
            match.add(strs[i]);
            i++;
        }

        for (String ss : match) {
            System.out.println(ss);
        }



    }

    @Test
    public void test(){
        String s = "start";
        System.out.println(s.startsWith("s"));
    }
}
