package ComprehensiveTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/28-16:35
 * @description
 */
public class LRB0828_1 {
    public static void main(String[] args) {

        // 先构造输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        sc.nextLine();

        // 构造数组存储重要性和id
        int[][] nums = new int[n][2];
        int idx = 1;
        while(idx < n + 1){
            int imptc = 0;
            for (String s : sc.nextLine().split(" ")) {
                imptc += Integer.parseInt(s);
            }
            nums[idx-1] = new int[]{imptc, idx};
            idx++;
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });

        for(int i = 0; i < nums.length; i++){
            if(nums[i][1] == id){
                System.out.println(i+1);
                break;
            }

        }
    }
}
