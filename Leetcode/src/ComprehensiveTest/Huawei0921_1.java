package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/21-19:20
 * @description
 */
public class Huawei0921_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx++ < n){
            String impu = sc.nextLine();
            if(fun(impu))
                sb.append(1 + " ");
            else
                sb.append(0 + " ");
        }

        System.out.println(sb.toString().substring(0, sb.length()-1));
    }

    // 判断一个字符串是否满足IMPU格式
    private static boolean fun(String impu) {
        if(impu.startsWith("tel:"))
            return fun_tel(impu);
        else if(impu.startsWith("sip:"))
            return fun_sip(impu);
        else
            return false;
    }

    // 判断一个以tel:开头的字符串是否满足
    private static boolean fun_tel(String impu) {
        impu = impu.substring(5, impu.length());
        if(fun_number(impu))    return true;
        else    return false;
    }

    // 判断一个以sip:开头的字符串是否满足
    private static boolean fun_sip(String impu) {

        boolean flag1 = false;
        boolean flag2 = false;
        String[] split = impu.substring(4,impu.length()).split("@");

        if(split.length != 2)    return false;

        if(split[0].startsWith("+"))
            flag1 = fun_number(split[0].substring(1,split[0].length()));
        else
            flag1 = fun_userinfo(split[0]);

        flag2 = fun_ip(split[1]);
        return flag2 && flag1;


    }

    private static boolean fun_number(String impu) {
        int n = impu.length();

        // 首字符为-或者长度小于6 返回false
        if(n < 6)   return false;
        if(impu.charAt(0) == '-' || impu.charAt(n-1) == '-')  return false;


        // 连续两个字符为-或者 返回false
        for(int i = 0; i < n-1; i++){
            if(impu.charAt(i) == '-' && impu.charAt(i+1) == '-')
                return false;
        }

        for(int i = 0; i < n; i++){
            char c = impu.charAt(i);
            if(!Character.isDigit(c) && c != '-')  return false;
        }

        return true;
    }

    private static boolean fun_userinfo(String s) {
        int n = s.length();

        if(n < 6)   return false;
        if(!Character.isAlphabetic(s.charAt(0)))    return false;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && !Character.isAlphabetic(c)) return false;
        }

        return true;
    }

    private static boolean fun_ip(String s) {
        int n = s.length();
        if(n < 3)   return false;

        if(s.charAt(0) == '.' || s.charAt(n-1) == '.')  return false;

        for(int i = 0; i < n-1; i++){
            if(s.charAt(i)=='.' && s.charAt(i+1)=='.')  return false;
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c) && !Character.isAlphabetic(c) && c!='.')    return false;
        }

        return true;
    }



}
