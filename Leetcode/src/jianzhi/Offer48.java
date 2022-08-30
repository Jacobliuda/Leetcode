package jianzhi;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/8/30-14:34
 * @description
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int cur = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(i != 0){
                int idx = map.getOrDefault(ch, -1);
                if(idx == -1 || i - idx > cur)
                    cur = cur + 1;
                else
                    cur = i - idx;
            }
            else    cur = 1;
            ans = Math.max(ans, cur);
            map.put(ch, i);
        }

        return ans;
    }

    @Test
    public void test(){
//        String s = "pwwkew";
//        int ans = lengthOfLongestSubstring(s);
//        System.out.println(ans);
        System.out.println("hello".substring(1,3));
    }
}
