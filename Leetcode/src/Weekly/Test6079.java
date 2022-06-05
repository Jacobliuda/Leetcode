package Weekly;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Collections;

/**
 * @author Jacob
 * @creator 2022/5/29-10:36
 * @description
 */
public class Test6079 {
    public String discountPrices(String sentence, int discount) {
        String[] split = sentence.split("\\s");
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder();
        for (String s1 : split) {
            if(s1.startsWith("$")){
                String substring = s1.substring(1);
                if(!substring.contains("$")){
                    try{
                        double d = Double.parseDouble(substring) * (1 - discount / 100.0d);
                        s1 = "$" + df.format(d);
                        System.out.println(s1);
                    }catch(Exception e){

                    }

                }
            }
            sb.append(" ");
            sb.append(s1);
        }
        return sb.deleteCharAt(0).toString();
    }

    @Test
    public void test(){
        String s = discountPrices("$76111 ab $6 $", 48);
        System.out.println(s);
    }
}
