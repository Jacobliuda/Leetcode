package Weekly;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Jacob
 * @creator 2022/1/9-10:40
 */
public class Test5976 {
    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[][] backup = new int[n][n];
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                backup[i][j] = matrix[i][j];
            }
        }
        int[] example = new int[n];
        for(int x = 0; x < n; x++)
            example[x] = x + 1;

        for(int i = 0; i < n; i++){
            if(!isSame(matrix[i],example))
                return false;
        }

        matrix = backup;
        for(int i=0; i<n; i++){
            int[] col = new int[n];
            for(int j=0; j<n; j++){
                col[j] = matrix[j][i];
            }
            if(!isSame(col,example))
                return false;
        }


        return true;
    }

    public static boolean isSame(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(Arrays.equals(nums1, nums2))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {3,1,2}, {2,3,1}};
        System.out.println(checkValid(matrix));
    }
}
