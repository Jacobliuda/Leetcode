package Undefined;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jacob
 * @creator 2022/5/26-20:10
 * @description
 */
public class Test17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0)    return list;

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();

        dfs(sb, 0, digits, list, map);
        return list;

    }

    private void dfs(StringBuilder sb, int cur, String digits, List<String> list, Map<Character, char[]> map){
        if(cur == digits.length()){
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }


        char[] chars = map.get(digits.charAt(cur));
        for(char ch: chars){
            StringBuilder builder = new StringBuilder(sb);
            builder.append(ch);
            dfs(builder, cur + 1, digits, list, map);
        }
    }

    @Test
    public void test() {
        List<String> strings = letterCombinations("");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
