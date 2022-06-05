package Weekly;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacob
 * @creator 2022/5/29-10:41
 * @description
 */
public class Test6078 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tgtMap = new HashMap<>();

        char[] chars = s.toCharArray();
        int ans = 100;
        for (char aChar : chars)
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        for(int i = 0; i < target.length(); i++)
            tgtMap.put(target.charAt(i), tgtMap.getOrDefault(target.charAt(i), 0) + 1);
        for (Character character : tgtMap.keySet()) {
            int tgtCnt = tgtMap.get(character);
            int cnt = map.getOrDefault(character, 0);
            if(cnt < tgtCnt)    return 0;
            ans = Math.min(ans, cnt / tgtCnt);
        }

        return ans;
    }

    @Test
    public void test() {
        String s = "abc", target = "abcd";
        int i = rearrangeCharacters(s, target);
        System.out.println(i);
    }
}
