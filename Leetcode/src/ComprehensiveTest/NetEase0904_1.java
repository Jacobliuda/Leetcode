package ComprehensiveTest;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/4-15:14
 * @description
 */
public class NetEase0904_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        while(n-- > 0){
            int i = sc.nextInt();
            max = Math.max(i, max);
            map.put(i, map.getOrDefault(i, 0) + 1);
            list.add(i);
        }

        for (Integer integer : list) {

            while(integer <= max){
                integer += k;
                if(integer <= max)
                    map.put(integer, map.getOrDefault(integer, 0) + 1);

            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            ans = Math.max(ans, entry.getValue());
        System.out.println(ans);

    }

    @Test
    public void test(){
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });
        map.put(2,2);
        map.put(1,1);
        map.put(4,4);
        map.put(3,3);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
