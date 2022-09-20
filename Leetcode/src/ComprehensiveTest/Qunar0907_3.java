package ComprehensiveTest;

import java.util.HashMap;
import org.junit.Test;
/**
 * @author Jacob
 * @creator 2022/9/7-20:25
 * @description
 */
public class Qunar0907_3 {
    public String showDown (String inHand) {
        // write code here

        String[] strings = inHand.split(" ");

        // array用来存储所有的牌
        // array[0]:S
        // array[1]:H
        // array[2]:C
        // array[3]:D

        boolean[][] array = new boolean[4][13];
        HashMap<Character, Integer> typeMap = new HashMap<Character, Integer>(){{
            put('S', 0);
            put('H', 1);
            put('C', 2);
            put('D', 3);
        }};

        HashMap<String, Integer> numMap = new HashMap<String, Integer>(){{
            put("A", 0);
            put("2", 1);
            put("3", 2);
            put("4", 3);
            put("5", 4);
            put("6", 5);
            put("7", 6);
            put("8", 7);
            put("9", 8);
            put("10",9);
            put("J", 10);
            put("Q", 11);
            put("K", 12);
        }};

        for (String string : strings) {
            char type = string.charAt(0);
            String num = string.substring(1, string.length());
            array[typeMap.get(type)][numMap.get(num)] = true;
        }

        String ans = "";

        // 皇家同花顺
        for(int i = 0; i < 4; i++){
            if(array[0][9]&&array[0][10]&&array[0][11]&&array[0][12]&&array[0][0]){
                ans = "HuangJiaTongHuaShun";
                return ans;
            }
        }

        // 同花顺
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                if(j + 4 >= 13) break;
                if(array[i][j]&&array[i][j+1]&&array[i][j+2]&&array[i][j+3]&&array[i][j+4]){
                    ans = "TongHuaShun";
                    return ans;
                }
            }
        }

        // 四条
        for(int j = 0; j < 13; j++){
            if(array[0][j]&&array[1][j]&&array[2][j]&&array[3][j]){
                ans = "SiTiao";
                return ans;
            }
        }

        // 葫芦
        if(true){
            int[] cnt = new int[13];
            for(int i = 0; i < 13; i++){
                if(array[0][i]) cnt[i] += 1;
                if(array[1][i]) cnt[i] += 1;
                if(array[2][i]) cnt[i] += 1;
                if(array[3][i]) cnt[i] += 1;
            }

            boolean flag_3=false, flag_2=false;
            for (int i : cnt) {
                if(i > 3){
                    flag_3 = true;
                    continue;
                }
                if(i > 2)   flag_2 = true;
            }

            if(flag_3 && flag_2){
                ans = "HuLu";
            }
        }

        return ans;
    }

    @Test
    public void test(){
        String inHand =  "SA SK SQ SJ S10 H10 C9";
        String s = showDown(inHand);
        System.out.println(s);
    }
}
