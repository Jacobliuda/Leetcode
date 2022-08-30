package ComprehensiveTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/6-10:54
 * @description 小美有n块魔法石，每块魔法石都有正反两面，每一面上都刻有一个魔法阵，初始状态下，n块魔法石都是正面向上。这n块魔法石的能量刚好可以构建一个大型魔法阵，但是需要至少一半的魔法石向上的一面铭刻的阵法相同才能触发大型魔法阵的效果。
 *
 *         小美希望翻转最少数量的魔法石，使得这个大型魔法阵被触发，请问她最少需要翻转多少块魔法石。
 *
 * 样例输入
 * 5
 * 1 5 7 5 5
 * 10 5 5 9 10
 * 样例输出
 * 0
 */
public class mt_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 记录魔法石数量
        int n = sc.nextInt();
        sc.nextLine();

        // 记录魔法石正反两面的能量
        int[] up = new int[n];
        int[] down = new int[n];

        for(int i = 0; i < n; i++)
            up[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            down[i] = sc.nextInt();

        // allMap 和 upMap 用来记录能量值在所有魔法石和魔法石正面中出现的次数
        HashMap<Integer, Integer> allMap = new HashMap<>();
        HashMap<Integer, Integer> upMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            // 先存入正面的魔法石
            allMap.put(up[i], allMap.getOrDefault(up[i], 0) + 1);

            // 如果正面和反面能量不相等就存入反面的魔法石
            if(up[i]!=down[i])
                allMap.put(down[i], allMap.getOrDefault(down[i], 0) + 1);

            upMap.put(up[i], allMap.getOrDefault(up[i], 0) + 1);
        }

        // 记录最优解
        int ans = 100000;

        // target 是 n 的一半
        int target = (n+1)/2;

        for(int key: allMap.keySet()){
            if(allMap.get(key) >= target){
                int tmp = upMap.getOrDefault(key,0)>=target?0:target-upMap.getOrDefault(key,0);
                ans = Math.min(ans, tmp);
            }
        }

        if(ans == 100000)
            System.out.println(-1);
        else
            System.out.println(ans);

    }
}
