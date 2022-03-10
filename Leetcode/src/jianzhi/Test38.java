package jianzhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/4-16:22
 */

/*
* 输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
* */

public class Test38 {

    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }


    private void dfs(int x) {
        if(x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++){
            if(set.contains(c[i]))  continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    @Test
    public void test(){
        String s = "aabbc";
        String[] permutation = permutation(s);


    }



}
