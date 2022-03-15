package Undefined;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/15-20:34
 */
public class Test76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        int needCnt = t.length();
        for(char ch: t.toCharArray())
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        int res_start = 0, res_end = s.length();
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            if(need.getOrDefault(ch, 0) > 0){
                needCnt--;
            }
            need.put(ch, need.getOrDefault(ch, 0) - 1);
            if(needCnt == 0){
                while (true){
                    char c = s.charAt(start);
                    if(need.get(c) == 0)  break;
                    need.put(c, need.get(c) + 1);
                    start += 1;
                }

                if(end - start < res_end - res_start){
                    res_end = end;
                    res_start = start;
                }
                need.put(s.charAt(start), need.get(s.charAt(start)) + 1);
                start += 1;
                needCnt += 1;
            }
        }
        return res_end == s.length() ? "" : s.substring(res_start, res_end + 1);
    }

    @Test
    public void test(){
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
}
