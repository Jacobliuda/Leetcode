package Daily;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/1/11-21:34
 */
public class Test306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int secondStart = 1; secondStart < n-1; secondStart++){
            //排除第一个数是多位0：如果第一个数是0 而第二个数不是从第1位开始 返回false
            if(num.charAt(0) == '0' && secondStart != 1)
                break;
            for(int secondEnd = secondStart; secondEnd < n - 1; secondEnd++){
                //排除第二个数是多位0：如果第二个数是0 但第二个数的首尾指针不等 返回false
                if(num.charAt(secondStart)=='0' && secondStart!=secondEnd)
                    break;
                if(valid(secondStart, secondEnd, num))
                    return true;
            }
        }

        return false;
    }

    //用于判断对于给定的第二个数的区间 能否满足累加和字符串的条件
    private boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0 , firstEnd = secondStart - 1;
        while(secondEnd <= n-1){
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if(thirdEnd >= n || !num.substring(thirdStart, thirdEnd+1).equals(third))
                return false;
            if(thirdEnd == n-1)
                return true;
            else{
                firstStart = secondStart;
                firstEnd = secondEnd;
                secondStart = thirdStart;
                secondEnd = thirdEnd;
            }
        }
        return true;

    }

    //对于给定的num字符串以及第一第二个数的首尾位置换算出这两个数相加得到的字符串
    private String stringAdd(String num, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while(firstEnd >= firstStart || secondEnd >= secondStart || carry != 0){
            cur = carry;
            if(firstEnd >= firstStart){
                cur += (num.charAt(firstEnd) - '0');
                --firstEnd;
            }
            if(secondEnd >= secondStart){
                cur += (num.charAt(secondEnd) - '0');
                --secondEnd;
            }
            carry = cur/10;
            cur = cur%10;
            third.append((char)(cur + '0'));
        }
        third.reverse();
        return third.toString();
    }

    @Test
    public void test(){
        String s = "112358";
        System.out.println(isAdditiveNumber(s));
    }
}
