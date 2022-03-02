package Undefined;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/2-20:21
 */

/*
* 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

    // 和第438题是一样的思路 只要找到一个异味词即可返回 true
public class Test567 {
    public boolean checkInclusion(String s, String p) {
        HashMap<Character, Integer> pmap = new HashMap<>();
        int len = p.length();
        for (int i = 0; i < len; i++)
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) +1);

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.equals(pmap))
                return true;
            if(end-start+1>=len){
                char d = s.charAt(start++);
                int orDefault = map.getOrDefault(d, 0);
                map.put(d, orDefault - 1);
                if(orDefault==1)
                    map.remove(d);

            }
        }
        return false;
    }
}
