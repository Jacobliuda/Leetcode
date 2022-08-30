package Shared;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Jacob
 * @creator 2022/5/15-21:16
 * @description This java file is used for test functions or any thing else the code not familiar with
 */
public class TestField {
    @Test
    public void test0() {
        Queue<Integer> queue = new LinkedList<>();
        queue.remove();
    }

    @Test
    public void test1() {
        String str1 = "abc";
        String str2 = "a" + "b" + "c";
        String str3 = new String("abc");
        String str4 = str3 + "";
        String str5 = new String("abc");
        System.out.println("str1==str2:" + (str1 == str2));
        System.out.println("str1==str3:" + (str1 == str3));
        System.out.println("str1==str4:" + (str1 == str4));
        System.out.println("str3==str5:" + (str3 == str5));

    }

    @Test
    public void test2() {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        ans.add(new ArrayList(tmp));
        tmp.remove(1);
        tmp.add(3);
        ans.add(new ArrayList(tmp));
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> integers = ans.get(i);
            for (int j = 0; j < integers.size(); j++)
                System.out.println(integers.get(j));
        }
    }

    @Test
    public void test3() {
        int[] nums = new int[]{
                7, 6, 4, 3, 1
        };
        int[] dp = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            min = Math.min(min, nums[i - 1]);
            dp[i] = Math.max(dp[i - 1], nums[i - 1] - min);
        }
        System.out.println(dp[nums.length]);
    }

    @Test
    public void test4() {
        // TreeMap 可以保证元素 key 有序 但是树的效率略低于 HashMap
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("linda", 1);
        map.put("gas", 7);
        map.put("cindy", 10);
        map.put("elle", 8);
        map.put("fiona", 6);
        map.put("aberfinch", 12);
        map.put("iowa", 4);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        map.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    @Test
    public void test5() {
        // LinkedHashMap可以保证元素按 插入有序
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        HashMap<String, Integer> map = new HashMap<>();
        map.put("linda", 1);
        map.put("gas", 7);
        map.put("cindy", 10);
        map.put("elle", 8);
        map.put("fiona", 6);
        map.put("aberfinch", 12);
        map.put("iowa", 4);


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    @Test
    public void test6() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "ddd");
        map.put("b", "bbb");
        map.put("a", "aaa");
        map.put("c", "ccc");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("map.get(key) is :" + map.get(key));
        }

        TreeMap<String, String> tmp = new TreeMap<String, String>();
        tmp.put("d", "ddd");
        tmp.put("b", "bbb");
        tmp.put("a", "aaa");
        tmp.put("c", "ccc");
        Iterator<String> iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            Object key = iterator_2.next();
            System.out.println("tmp.get(key) is :" + tmp.get(key));
        }
    }

    @Test
    public void test7() {
        // ArrayList remove() 方法测试
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0, 1);
        list.remove(1);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void test8() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.addLast(3);
        Integer poll = list.element();
        System.out.println(poll);
        list.remove();

        poll = list.element();
        System.out.println(poll);
        list.remove();

        poll = list.element();
        System.out.println(poll);
    }

    @Test
    public void test9() {
        HashMap<Integer, Integer> map = new HashMap<>();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        map.put(null, 1);
        map.put(null, null);
        map.put(2, null);

        table.put(1, null);

        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }


    // 测试 ArrayList 的扩容机制
    @Test
    public void test10() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

    }

    // 测试 Arrays.copyOf()
    @Test
    public void test11() {
        int[] ints = {1, 2, 3, 4, 5};
        int[] ints1 = Arrays.copyOf(ints, 3);
        for (int i : ints1) {
            System.out.println(i);
        }
        System.out.println("**********");

        int[] ints2 = Arrays.copyOf(ints, 5);
        for (int i : ints2) {
            System.out.println(i);
        }
        System.out.println("**********");

        int[] ints3 = Arrays.copyOf(ints, 7);
        for (int i : ints3) {
            System.out.println(i);
        }
        System.out.println("**********");
    }

    //测试::操作符
    @Test
    public void test12() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        list.forEach(System.out::println);
//        list.forEach()
    }

    @Test
    public void test13() {
//        System.out.println("20.0" < "20.1");
        compare("", "");
    }

    public void compare(String s1, String s2){
        System.out.println((100 / (double)5) == (double)20);
    }
}





