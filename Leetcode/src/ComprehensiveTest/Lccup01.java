package ComprehensiveTest;
import org.junit.Test;


/**
 * @author Jacob
 * @creator 2022/4/16-15:03
 * @description
 */
public class Lccup01 {
    public int giveGem(int[] gem, int[][] operations) {
        int mmax = Integer.MIN_VALUE;
        int mmin = Integer.MAX_VALUE;

        for(int i = 0; i < operations.length; i++){
            int a = operations[i][0], b = operations[i][1];
            int give = gem[a] / 2;
            gem[a] -= give;
            gem[b] += give;
        }
        for(int i = 0; i < gem.length; i++){
            mmax = Math.max(mmax, gem[i]);
            mmin = Math.min(mmin, gem[i]);
        }
        return mmax - mmin;
    }

    @Test
    public void test(){
        int[] gem = new int[]{100,0,50,100};
        int[][] operations = new int[][]{{0,2},{0,1},{3,0},{3,0}};
        System.out.println(giveGem(gem, operations));
    }
}
