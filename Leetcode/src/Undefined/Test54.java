package Undefined;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author Jacob
 * @creator 2022/3/13-19:53
 */
public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int dr = 0, i = 0, j = 0;
        int rowBegin = 0, rowEnd = m-1, colBegin = 0, colEnd = n-1;
        while(res.size() < m * n){
            if(dr==0){
                res.add(matrix[i][j++]);
                if(j > colEnd){
                    j--;
                    dr = 1;
                    colEnd--;
                    i++;
                }
            }else if(dr==1){
                res.add(matrix[i++][j]);
                if(i > rowEnd){
                    i--;
                    dr=2;
                    rowEnd--;
                    j--;
                }
            }else if(dr==2){
                res.add(matrix[i][j--]);
                if(j < colBegin){
                    j++;
                    dr=3;
                    colBegin++;
                    i--;
                }
            }else{
                res.add(matrix[i--][j]);
                if(i < rowBegin + 1){
                    i++;
                    dr=0;
                    rowBegin++;
                    j++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[][] matrix = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        List<Integer> integers = spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
