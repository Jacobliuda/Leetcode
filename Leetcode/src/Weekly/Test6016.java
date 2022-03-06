package Weekly;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/6-10:36
 */
public class Test6016 {
    public List<String> cellsInRange(String s) {
        char st = s.charAt(0);
        char nst = s.charAt(1);
        char end = s.charAt(3);
        char nend = s.charAt(4);

        ArrayList<String> ans = new ArrayList<>();

        for(char c = st; c <= end; c++){
            for(char d = nst; d <= nend; d++)
                ans.add(build(c, d));
        }

        return ans;

    }

    public String build(char col, char row){
        return "" + col + row;
    }

    @Test
    public void test(){
        String s = "K1:L2";
        List<String> strings = cellsInRange(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
