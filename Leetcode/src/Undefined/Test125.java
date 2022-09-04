package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/9/2-19:53
 * @description
 */
public class Test125 {
    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while(i < j){
            while(i < j && !Character.isAlphabetic(array[i]) && !Character.isDigit(array[i]))    i++;
            while(i < j && !Character.isAlphabetic(array[j]) && !Character.isDigit(array[j]))    j--;


            if(Character.isAlphabetic(array[i]) && Character.isAlphabetic(array[j])){
                int d = array[i] - array[j];
                if(d == 0 || d == 32 || d == -32){
                    i++;
                    j--;
                    continue;
                }
                else    return false;
            }else if(Character.isDigit(array[i]) && Character.isDigit(array[j]) && array[i] == array[j]){
                i ++;
                j --;
                continue;
            }else   return false;

        }

        return true;
    }

    @Test
    public void test(){
        String s = "ab2a";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
}
