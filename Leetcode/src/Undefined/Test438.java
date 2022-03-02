package Undefined;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/2-19:40
 */

/*
* 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class Test438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pmap = new HashMap<>();
        int len = p.length();
        for (int i = 0; i < len; i++)
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) +1);

        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.equals(pmap))
                ans.add(start);
            if(end-start+1>=len){
                char d = s.charAt(start++);
                int orDefault = map.getOrDefault(d, 0);
                map.put(d, orDefault - 1);
                if(orDefault==1)
                    map.remove(d);

            }
        }
        return ans;
    }

    @Test
    public void test(){
        String s = "abab", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }

    }
}
