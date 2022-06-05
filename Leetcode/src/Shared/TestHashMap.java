package Shared;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/29-8:49
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "hello");
        hashMap.put(1, "hello");
        String s = new String("helloworld");
//        System.out.println(s.hashCode());

        String s1 = new String("");
        String s2 = new String("");
        System.out.println(s1==s2);
    }


}
