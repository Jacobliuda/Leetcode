package Undefined;

/**
 * @author Jacob
 * @creator 2022/3/6-19:23
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test8 {
    public int myAtoi(String s) {
        Automation automation = new Automation();
        for(int i = 0; i < s.length(); i++)
            automation.get(s.charAt(i));
        return automation.ans;
    }

    @Test
    public void test(){
        System.out.println(myAtoi("42"));
    }

}

class Automation{
    int flag = 1;
    int ans = 0;
    String state = "initial";
    private Map<String, String[]> map = new HashMap<String, String[]>(){{
        put("initial", new String[]{"initial", "symbol", "number", "end"});
        put("symbol", new String[]{"end", "end", "number", "end"});
        put("number", new String[]{"end", "end", "number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    private int getCol(char c){
        if(c == ' ')
            return 0;
        else if(c == '+' || c =='-')
            return 1;
        else if(Character.isDigit(c))
            return 2;
        else
            return 3;
    }

    void get(char c){
        int col = getCol(c);
        state = map.get(state)[col];
        if("number".equals(state)){
            if(flag == 1){
                if(ans < 214748364 || (ans == 214748364 && c - '0' <= 7))
                    ans = ans * 10 + c - '0';
                else
                    ans = Integer.MAX_VALUE;
            }else{
                if(ans > -214748364 || (ans == -214748364 && c - '0' <= 8))
                    ans = ans * 10 - c + '0';
                else
                    ans = Integer.MIN_VALUE;
            }
        }else if("symbol".equals(state))
            flag = c == '+' ? 1 : -1;
    }
}
