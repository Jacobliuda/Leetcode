package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/6-11:41
 * @description 小美和小团拥有一个字符串生成机器，每次将字符串s丢入这个机器中，这个机器将会弹出s+r(s)+”wow”，其中，加号表示字符串的拼接，r(s)表示将字符串s逆序。
 *
 *         例如当s=”abc”时，得到的字符串为s+r(s)+”wow”=”abccbawow”。
 *
 *         当s=”MeiTuan”时，得到的字符串为”MeiTuannauTieMwow”。
 *
 *         小美和小团想知道，如果有一个初始字符串”MeiTuan”，然后将这个字符串丢入机器得到一个新串，然后不断地将新串再次丢入机器中，循环往复得到的无限长的字符串的第k位字符（k从1开始）是什么？（根据生成规则可知，每次丢入机器的串都会是生成的结果串的一个前缀）
 *
 * 样例输入
 * 3
 * 31
 * 51
 * 67
 * 样例输出
 * T
 * T
 * n
 *
 * 提示
 *     第1次生成的串为”MeiTuannauTieMwow”
 *
 *     第2次生成的串为”MeiTuannauTieMwowwowMeiTuannauTieMwow”
 *
 *     第3次生成的串为
 *
 * ”MeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwow”
 *
 * 该字符串的第31、51、67为分别为T、T、n
 *
 * 思路：每20个为一组 后面就是重复的
 */
public class mt_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int c = sc.nextInt();

            // code starts here
            System.out.println(func(c));
        }
    }

    public static char func(int c){
        char[] string = "MeituannautieMwoooow".toCharArray();
        int idx = c % 20;
        return string[idx-1];
    }
}
