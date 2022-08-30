package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/8/28-10:50
 * @description 求最大同时在线人数和同时在线人数最大的时间区间
 * 输入
 * 7
 * 00:19:19 00:20:01
 * 00:19:03 00:20:03
 * 00:35:05 00:39:25
 * 00:20:00 00:20:02
 * 00:30:57 00:37:05
 * 00:33:33 00:36:40
 * 00:05:25 00:07:28
 *
 * 输出
 * 3
 * 00:20:00 00:20:01
 * 00:35:05 00:36:40
 */
public class ByteDance0828_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        while(idx < n){
            String[] string = sc.nextLine().split(" ");
            int start = map.getOrDefault(string[0], 0);
            int end = map.getOrDefault(string[1], 0);
            map.put(string[0],start + 1);
            map.put(string[1],end - 1);
            idx++;
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // 先统计出某个时间点的在线人数，并同时统计出最大的在线人数
        HashMap<String, Integer> countMap = new HashMap<>();
        int cnt = 0;
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            int val = entry.getValue();
            cnt += val;
            maxCnt = Math.max(maxCnt, cnt);
            countMap.put(key, cnt);
        }

        // 然后根据某时间点的在线人数等于最大在线人数计入结果集
        ArrayList<String> ans = new ArrayList<>();
        int i = 0;
        while(i < entries.size()){
            String key = entries.get(i).getKey();
            int val = countMap.get(key);
            if(val == maxCnt){
                ans.add(key + " " + entries.get(i+1).getKey());
            }
            i++;
        }

        System.out.println(maxCnt);
        for (String an : ans) {
            System.out.println(an);
        }

    }
}
