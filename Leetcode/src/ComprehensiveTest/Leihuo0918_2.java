package ComprehensiveTest;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/18-19:43
 * @description
 */
public class Leihuo0918_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int idx = 0;

        while(idx++ < n){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y1 = sc.nextInt();
            int y2 = sc.nextInt();
            sc.nextLine();

            set.add(new int[]{x1, y1});
            set.add(new int[]{x1, y2});
            set.add(new int[]{x2, y1});
            set.add(new int[]{x2, y2});

        }

        for (int[] ints : set) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
    
    @Test
    public void test(){
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Object> objects = new ArrayList<>();
        new LinkedList<Object>();
    }
}
