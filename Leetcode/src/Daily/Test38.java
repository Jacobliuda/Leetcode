package Daily;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/8/11-19:05
 * @description
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Test38 {

    List<String> list;

    public String[] permutation(String s) {
        list = new ArrayList<>();
        char[] s2c = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        StringBuilder path = new StringBuilder();

        Arrays.sort(s2c);

        dfs(s2c, visited, path);

        return list.toArray(new String[list.size()]);
    }

    private void dfs(char[] s2c, boolean[] visited, StringBuilder path) {

        if(path.length() == s2c.length){
            list.add(path.toString());
            return;
        }

        for(int i = 0; i < s2c.length; i++){
            if(visited[i])
                continue;

            if(i != 0 && s2c[i] == s2c[i-1] && !visited[i-1])
                continue;

            path.append(s2c[i]);
            visited[i] = true;
            dfs(s2c, visited, path);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }


    @Test
    public void test(){
        String s = "abc";
        String[] permutation = permutation(s);
        for (String s1 : permutation) {
            System.out.println(s1);
        }
    }
}

