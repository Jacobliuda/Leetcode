package Undefined;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/3/17-15:43
 */
public class Test394 {
    public String decodeString(String s) {

        // 使用两个栈 分别用来记录 数字 和 其他所有字符
        Stack<Integer> stack_num = new Stack<>();
        Stack<String> stack_string = new Stack<>();

        char[] chars = s.toCharArray();
        for(char ch: chars){
            // 如遇到数字 进入数字栈
            if (Character.isDigit(ch))
                stack_num.push(ch - '0');

            // 如遇到字母 进入其他栈
            else if (Character.isAlphabetic(ch))
                stack_string.push(String.valueOf(ch));

            // 如遇到 [ 进入其他栈 并在数字栈做标记
            else if (ch == '['){
                stack_num.push(-1);
                stack_string.push(String.valueOf("["));
            }

            // 遇到 ] 开始出栈进行拼接 后入栈
            else{

                // 新建一个 StringBuilder 来记录一次解码
                StringBuilder tmp = new StringBuilder();

                // 当栈不为空且 没有到本次解码的头 即 左括弧 [ 时 在 tmp 前面插入该字符（串）保证顺序
                while (!stack_string.isEmpty() && !"[".equals(stack_string.peek()))
                    tmp.insert(0, stack_string.pop());

                // 遇到左括弧 弹出一次
                stack_string.pop();

                // 同时弹出数字栈的 标记 -1
                stack_num.pop();

                // cnt 用于计数括弧前的数字来判断括弧里面的字符串重复几次
                int cnt = 0;
                StringBuilder cntString = new StringBuilder();

                // 计算重复次数
                while (!stack_num.isEmpty() && -1 != stack_num.peek())
                    cntString.insert(0, stack_num.pop());
                cnt = Integer.parseInt(cntString.toString());

                // 根据 cnt 次数来重复字符串
                StringBuilder pushBack = new StringBuilder();
                while(cnt-- > 0)
                    pushBack.append(tmp);

                // 重复以后在压入栈
                stack_string.push(pushBack.toString());
            }
        }

        // 当字符串遍历结束以后再用插入的方式汇总
        StringBuilder sb = new StringBuilder();
        while(!stack_string.isEmpty())
            sb.insert(0, stack_string.pop());
        return sb.toString();
    }

    @Test
    public void test(){
        String s = "10[leetcode]";
        String s1 = decodeString(s);
        System.out.println(s1);
//        System.out.println("[".equals(new StringBuilder("[").toString()));
    }
}
