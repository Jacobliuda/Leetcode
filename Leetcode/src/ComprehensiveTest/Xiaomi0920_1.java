package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/20-18:51
 * @description
 */
public class Xiaomi0920_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> array = new ArrayList<>();

        while(true){
            String[] s = sc.nextLine().split(" ");

            if(s.length == 1)   break;

            array.add(new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])});
        }

        Collections.sort(array, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[2];
            }
        });

        int[][] ans = new int[array.size()][2];
        int idx = -1;

        for(int i = 0; i < array.size(); i++){
            int[] ints = array.get(i);
            if(idx == -1 || ans[idx][1] < ints[0])
                ans[++idx] = ints;
            else
                ans[idx][1] = Math.max(ans[idx][1], ints[1]);
        }

        int cnt = 0;
        for (int[] an : ans) {
            cnt += an[1] - an[0];
        }

        System.out.println(cnt);
    }

    @Test
    public void test(){
        String[] s = "".split(" ");
        System.out.println(s.length);
    }
}
