package Top100;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/8/22-16:18
 * @description
 */
public class Test49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = array.toString();
            System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);

    }
}
