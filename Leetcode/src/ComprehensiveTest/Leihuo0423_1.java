package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/23-19:01
 * @description
 */
public class Leihuo0423_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] string = new String[6];
        int i = 0;
        int ans = 0;
        while(num > 0){
            string[i] = sc.nextLine();
            i++;
            if(i % 6 == 0) {
                num--;
                if(func(string))
                    ans += 1;
                string = new String[6];
                i = 0;
            }
        }
        System.out.println(ans);

    }

    public static boolean func(String[] string){
        // 定义字典并初始化
        ArrayList<HashMap<Character, Boolean>> rowMap = new ArrayList<>();
        ArrayList<HashMap<Character, Boolean>> colMap = new ArrayList<>();
        ArrayList<HashMap<Character, Boolean>> boxMap = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            rowMap.add(new HashMap<Character, Boolean>());
            colMap.add(new HashMap<Character, Boolean>());
            boxMap.add(new HashMap<Character, Boolean>());
        }

        for(int i = 0; i < 6; i++){
            HashMap<Character, Boolean> row = rowMap.get(i);
            for(int j = 0; j < 6; j ++){
                // 找到对应的小宫格索引
                HashMap<Character, Boolean> col = colMap.get(j);
                HashMap<Character, Boolean> box = boxMap.get(2 * (i / 2) + (j / 3));

                char ch = string[i].charAt(j);
                if(row.getOrDefault(ch, false) || col.getOrDefault(ch, false) || box.getOrDefault(ch, false))
                    return false;

                row.put(ch, true);
                col.put(ch, true);
                box.put(ch, true);
            }
        }
        return true;

    }

    @Test
    public void test(){
        int i = 2, j = 5;
        System.out.println(2 * (i / 2) + (j / 3));
    }
}
