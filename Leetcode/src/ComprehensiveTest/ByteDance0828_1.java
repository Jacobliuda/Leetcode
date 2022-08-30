package ComprehensiveTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/28-10:05
 * @description 松鼠藏干果
 */
public class ByteDance0828_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        // 存储二叉树元素
        for (String s : sc.nextLine().split(" "))
            array.add(Integer.parseInt(s));

        int n = sc.nextInt();

        // 判断数据是否合法，合法的条件为
        // 1.空节点不能有子节点
        // 2.每个节点的元素值不能大于五

        boolean flag = true;
        int i = 0;
        if(n < 0)
            flag = false;
        else{
            while(i < array.size()){
                int cur = array.get(i);
                if(cur > 5){
                    flag = false;
                    break;
                }
                if(cur == -1){
                    int left = i * 2 + 1;
                    int right = i * 2 + 2;
                    if(left < array.size() && array.get(left) != -1){
                        flag = false;
                        break;
                    }
                    if(right < array.size() && array.get(right) != -1){
                        flag = false;
                        break;
                    }
                }
                i++;
            }
        }

        if(!flag) {
            System.out.println("false");
            System.out.println(0);
        }else{
            for (int integer : array) {
                if(integer != -1)
                    n -= (5-integer);
            }
            System.out.println("true");
            System.out.println(n > 0 ? n : 0);
        }


    }
}
