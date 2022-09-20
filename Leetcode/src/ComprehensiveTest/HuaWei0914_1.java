package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/14-19:31
 * @description
 */
public class HuaWei0914_1 {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;

        // nums 存储所有需要排序的资源信息，每一组资源信息包括id和结束时间
        List<int[]> nums = new ArrayList<>();

        // map 用来存储 id 和资源的对应关系
        Map<Integer, List<int[]>> map = new HashMap<>();

        while(idx < n){
            // 获取输入数据
            int id = sc.nextInt();
            int start = sc.nextInt();
            int last = sc.nextInt();

            // 如果该id的资源之前没出现过 直接放入列表
            if(!map.containsKey(id))
                nums.add(new int[]{id, start + last});
                // 否则, 需要判断是否与之前id相同的资源有没有包含关系
            else{
                List<int[]> ints = map.get(id);
                for (int[] num : ints) {

                    // 如果此时的开始时间已经迟于原来的资源结束时间，该资源被认为是新的资源
                    if(num[2] < start)
                        nums.add(new int[]{id, start + last});
                    else{
                        for(int i = 0; i < nums.size(); i++){
                            if(nums.get(i)[0] == id && nums.get(i)[1] < start){
                                nums.set(i, new int[]{id, start + last});
                                break;
                            }
                        }
                    }
                }
            }
            List<int[]> ints = map.get(id);
            ints.add(new int[]{id, start, start + last});

            idx++;
        }

        Collections.sort(nums, (o1, o2) -> o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for(int[] num: nums){
            System.out.print(num[0] + " ");
        }
        System.out.print(0);
    }
}
