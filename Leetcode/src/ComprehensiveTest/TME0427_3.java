package ComprehensiveTest;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jacob
 * @creator 2022/4/27-19:28
 * @description
 */
public class TME0427_3 {
    public int howMany (String S, int k) {
        // write code here
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(set.contains(ch))    continue;
            Integer orDefault = map.getOrDefault(ch, 0);
            map.put(ch, orDefault + 1);
            if(orDefault >= k - 1){
                set.add(ch);
            }
        }
        return set.size();
    }

}
