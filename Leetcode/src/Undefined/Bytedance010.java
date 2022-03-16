package Undefined;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/3/16-18:20
 */
public class Bytedance010 {
    public static void main(String[] args){
        //获取输入
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");

        // 对输入进行处理 去除首尾的括号
        split[0] = split[0].substring(1);
        split[split.length-1] = split[split.length-1].substring(0, split[split.length-1].length()-1);

        Arrays.sort(split, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                if(Integer.parseInt(o1 + o2) < Integer.parseInt(o2 + o1))
                    return 1;
                else if(Integer.parseInt(o1 + o2) > Integer.parseInt(o2 + o1))
                    return -1;
                else return 0;
            }
        });
        StringBuilder result = new StringBuilder();
        for(String str: split){
            result.append(str);
        }
        System.out.println(result.toString());

    }



}
