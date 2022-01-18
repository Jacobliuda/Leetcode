package Daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**539.最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * @author Jacob
 * @creator 2022/1/18-20:20
 */
public class Test539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        String t0min = timePoints.get(0);
        String baseMin = timePoints.get(0);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < timePoints.size(); i++){
            String curMin = timePoints.get(i);
            min = Math.min(min, getMinute(curMin) - getMinute(baseMin));
            baseMin = curMin;
        }
        min = Math.min(min, getMinute(t0min) + 1440 - getMinute(baseMin));
        return min;

    }

    public int getMinute(String str){
        return ((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0')) * 60 + (str.charAt(3) - '0') * 10 + str.charAt(4) - '0';
    }

    @Test
    public void test(){
        String[] time = new String[]{"00:00","23:59","00:00"};
        List<String> timePoints = Arrays.asList(time);
        int minDifference = findMinDifference(timePoints);
        System.out.println(minDifference);
    }
}
