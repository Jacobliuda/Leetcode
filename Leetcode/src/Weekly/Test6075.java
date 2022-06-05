package Weekly;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/5/22-11:20
 * @description
 */
public class Test6075 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] need = new int[capacity.length];
        for(int i = 0; i < capacity.length; i ++){
            need[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(need);
        int cnt;
        for(cnt = 0; cnt < capacity.length; cnt++) {
            int cur_need = need[cnt];
            if(cur_need == 0)  continue;
            if(cur_need <= additionalRocks)  additionalRocks-=cur_need;
            else break;
        }
        return cnt;
    }

    @Test
    public void test() {
        //capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
        int[] capacity = new int[]{2,3,4,5};
        int[] rocks = new int[]{1,2,4,4};
        int additionalRocks = 2;
        int i = maximumBags(capacity, rocks, additionalRocks);
        System.out.println(i);
    }
}
