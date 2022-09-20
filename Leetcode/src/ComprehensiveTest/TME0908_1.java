package ComprehensiveTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jacob
 * @creator 2022/9/8-19:08
 * @description
 */
public class TME0908_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回满足题意的最小操作数
     * @param str string字符串 给定字符串
     * @return int整型
     */
    public int minOperations (String str) {
        // write code here
        int[] array = new int[26];
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            array[ch - 'a'] += 1;
        }

        int a = 0, b = 0;
        for(int i = 0; i < 26; i++){
            b += array[i] / 2;
            a += array[i] % 2;
        }
        if(b < 26 - a)  return b;
        else    return 2 * b - 26 + a;
    }

    private boolean satisfy(Map<Character, Integer> map){
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1)    return false;
        }
        return true;
    }

    @Test
    public void test(){
        String str = "ababababaacc";
        System.out.println(minOperations(str));
    }
}
