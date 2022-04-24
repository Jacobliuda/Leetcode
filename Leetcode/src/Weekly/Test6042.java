package Weekly;

/**给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。

 注意：

 格点 是指整数坐标对应的点。
 圆周上的点 也被视为出现在圆内的点。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-lattice-points-inside-a-circle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Jacob
 * @creator 2022/4/24-13:06
 * @description
 */
public class Test6042 {

    public int countLatticePoints(int[][] circles) {
        int x_min= Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int x_max = 0;
        int y_max = 0;

        for (int[] circle : circles) {
            x_min = Math.min(x_min, circle[0]-circle[2]);
            y_min = Math.min(y_min, circle[1]-circle[2]);
            x_max = Math.max(x_max, circle[0]+circle[2]);
            y_max = Math.max(y_max, circle[1]+circle[2]);
        }

        int ans = 0;
        for(int x = x_min; x <= x_max; x++){
            for(int y = y_min; y <= y_max; y++){
                for(int[] circle: circles){
                    double dis = Math.pow((x - circle[0]), 2) + Math.pow((y - circle[1]), 2);
                    if(dis <= Math.pow(circle[2], 2)){
                        ans+=1;
                        break;
                    }
                }
            }
        }
        return ans;


    }
}
