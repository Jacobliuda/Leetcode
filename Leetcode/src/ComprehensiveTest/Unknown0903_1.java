package ComprehensiveTest;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/3-20:14
 * @description
 */
public class Unknown0903_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt();

        while(ns-- > 0){
            int n = sc.nextInt();
            int ans = fun(n);
            System.out.println(ans);
        }
    }

    static int fun(int n){
        // 先找出每个数的所有因子
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(n % i == 0){
                if(i * i > n)
                    return i;
            }
        }

        // 如果是质数 返回自身
        return n;
    }

    @Test
    public void test(){
        int[] nums = new int[]{3,30,34,5,9};
        List<String> list = new ArrayList<>();
        for(int num: nums)
            list.add(String.valueOf(num));
        Collections.sort(list, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
