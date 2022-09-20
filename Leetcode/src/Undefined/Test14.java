package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/9-16:18
 */
public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)    return new String();
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            if(prefix.length() == 0)
                return "";
        }
        return prefix;
    }

    public String longestCommonPrefix(String s1, String s2){
        int length = Math.min(s1.length(), s2.length());
        int idx = 0;
        while(idx < length && s1.charAt(idx) == s2.charAt(idx)) idx++;
        return s1.substring(0, idx);
    }

    public String longestCommonPrefix2(String[] strs) {
        String s = strs[0];
        for(String string: strs){
            while(!string.startsWith(s)){
                if(s.length() == 0) return "";
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;

    }

    @Test
    public void test(){
        String[] strs = new String[]{"flower","flow","flight"};
        String s = longestCommonPrefix2(strs);
        System.out.println(s);
    }
    
}
