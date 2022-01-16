package Daily;

/**替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * @author Jacob
 * @creator 2022/1/5-19:00
 */
public class Test1576 {
    public static String modifyString(String s) {
        int length = s.length();
        char[] array = s.toCharArray();
        for(int i = 0; i < length; i++){
            if(array[i]=='?'){
                char ch = 'a';
                //如果当前字符不是第一个也不是最后一个字符
                while((i>0&&ch==array[i-1])||(i<length-1&&ch==array[i+1]))
                    ch+=1;
                array[i] = ch;
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "ubv?w";
        System.out.println(modifyString(s));
    }
}
