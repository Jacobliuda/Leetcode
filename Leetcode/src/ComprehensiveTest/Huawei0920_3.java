package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/21-20:06
 * @description
 */
public class Huawei0920_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] adjoin = new boolean[n][n];
        int[] weight = new int[n];

        int idx = 0;
        while(idx < n){
            weight[idx] = sc.nextInt();
            idx++;
        }

        idx = 0;
        while(idx < n){

            int cnt = sc.nextInt();
            while(cnt > 0){
                int pre = sc.nextInt();
                adjoin[pre][idx] = true;
                cnt--;
            }

            idx ++;
        }

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new LinkedList<>());
        }

        HashSet<Integer> set = new HashSet<>();
        idx = 0;
        while(idx < n){
            for(int i = 0; i < n; i++){
                boolean flag = true;
                for(int j = 0; j < n; j++){
                    if(adjoin[j][i] && !set.contains(j))
                        flag = false;
                }

                if(flag){
                    if(!set.contains(i)){
                        map.get(idx).add(i);
                        set.add(i);
                    }

                }
            }
            idx++;
        }

        int ans = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
            LinkedList<Integer> value = entry.getValue();
            ans += fun(value, weight);
        }

        System.out.println(ans);

    }

    private static int fun(LinkedList<Integer> list, int[] weight){
        int s = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++)
            s = Math.max(s, weight[list.get(i)]);

        return s;
    }
}
