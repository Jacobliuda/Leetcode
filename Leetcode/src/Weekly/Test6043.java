package Weekly;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**6043. 统计包含每个点的矩形数目
 *
 * @author Jacob
 * @creator 2022/4/24-10:50
 * @description
 */
public class Test6043 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // 先对传入的 rectangles 进行排序，按照 y 升序排列
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        // 将对应高度的矩形框装入对应高度的数组下标里面
        ArrayList<int[]>[] pos = new ArrayList[105];
        for(int i = 1; i <= 100; i++)
            pos[i] = new ArrayList<int[]>();
        for (int[] rectangle : rectangles)
            pos[rectangle[1]].add(rectangle);

        int[] ans = new int[points.length];
        // 遍历 points
        for(int i = 0; i < points.length; i++){
            int tmp = 0;
            int[] point = points[i];
            for(int j = point[1]; j <= 100; j++){
                // 从 y 值相等的矩形框算起，二分查找算出每个 arraylist中 x y值都比当前点大的个数
                ArrayList<int[]> cur = pos[j];
                int l = 0, r = cur.size();
                while(l < r){
                    int m = l + (r - l) / 2;
                    if(cur.get(m)[0] >= point[0])
                        r = m;
                    else
                        l = m + 1;
                }
                tmp += cur.size() - l;
            }
            ans[i] = tmp;
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] rectangles = new int[][]{{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}};
        int[][] rectangles_2 = new int[][]{{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}};

        int[][] points = new int[][]{{10, 3}, {8, 10}, {2, 3}, {5, 4}, {8, 5}, {7, 10}, {6, 6}, {3, 6}};
        int[] ints = countRectangles(rectangles, points);
        for (int i : ints)
            System.out.println(i);
    }
}
