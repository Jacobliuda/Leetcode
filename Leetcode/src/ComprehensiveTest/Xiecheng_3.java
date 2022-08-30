package ComprehensiveTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/30-20:49
 * @description
 */
public class Xiecheng_3 {
    private static boolean[] visited;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n-1][2];
        char[] colors = sc.next().toCharArray();
        visited = new boolean[n];
        ArrayList<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            graph.add(new ArrayList<>());
        }
    }
}
