package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/7/17-21:10
 * @description
 */
public class ByteCamp1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = 0;
//        boolean[][] matrix = new boolean[n+1][n+1];
//
//        while(i < n){
//            String s = sc.nextLine();
//            String[] tmp = s.split(" ");
//            int start = Integer.parseInt(tmp[3].substring(2));
//            int end = Integer.parseInt(tmp[4].substring(2));
//            matrix[start][end] = true;
//            i++;
//        }
        int len = 5;
        boolean[][] matrix = new boolean[5][5];

        // 设定输入数据
        matrix[0] = new boolean[]{false, true, true, false, false};
        matrix[1] = new boolean[]{false, false, true, true, false};
        matrix[2] = new boolean[]{false, false, false, true, true};
        matrix[3] = new boolean[]{true, false, false, false, true};
        matrix[4] = new boolean[]{true, true, false, false, false};


        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> longestPath = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            dfs(matrix, i, list, 0, longestPath);
        }
        for (Integer integer : longestPath) {
            System.out.println(integer);
        }


    }

    public static void dfs(boolean[][] matrix, int start, ArrayList trace, int curLength, ArrayList longestPath){
        trace.add(start);
        curLength += 1;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[start][i]){
                dfs(matrix, i, trace, curLength, longestPath);
            }else{
                if(curLength > longestPath.size())
                    longestPath = new ArrayList(trace);
                trace.remove(trace.size()-1);
            }
        }
    }

    @Test
    public void test(){
        String s = "hello";
        System.out.println(s.substring(2));
    }
}
