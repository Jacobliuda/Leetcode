package Weekly;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jacob
 * @creator 2022/5/22-10:40
 * @description
 */
public class Test6076 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int cnt = 0;
        int delta_x = 0;
        int delta_y = 0;
        int pre_x = stockPrices[0][0];
        int pre_y = stockPrices[0][1];
        for(int i = 1; i < stockPrices.length; i ++){
            int[] stockPrice = stockPrices[i];
            int x = stockPrice[0];
            int y = stockPrice[1];
            if(i==1){
                delta_x = x - pre_x;
                delta_y = y - pre_y;
                pre_x = x;
                pre_y = y;
                cnt++;
                continue;
            }

            // 判断斜率是否相等
            if((x-pre_x) * delta_y != (y-pre_y) * delta_x){
                cnt ++;
                delta_x = x - pre_x;
                delta_y = y - pre_y;
            }
            pre_x = x;
            pre_y = y;
        }
        return cnt;
    }

    @Test
    public void test(){
        //[[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
        int[][] stockPrices = new int[][]{{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        int i = minimumLines(stockPrices);
        System.out.println(i);
    }
}
