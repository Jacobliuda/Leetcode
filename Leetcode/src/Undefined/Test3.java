package Undefined;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/2-17:16
 */
public class Test3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        for(int end = 0; end < length; end++){
            int orDefault = map.getOrDefault(chars[end], 0);
            map.put(chars[end], orDefault+1);
            if(end-start+1==map.size()){
                ans = Math.max(ans, map.size());
            }
            while(end-start+1>map.size()){
                char c = chars[start++];
                map.put(c, map.get(c)-1);
                if(map.get(c)==0)
                    map.remove(c);
            }
        }

        return ans;
    }

    @Test
    public void test(){
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
