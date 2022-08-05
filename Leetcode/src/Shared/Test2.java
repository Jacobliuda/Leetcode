package Shared;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/6/27-15:16
 * @description
 */
public class Test2{
    public static void main(String [] args){
        List<Integer> nums;
        nums = new ArrayList<Integer>();
        int[] num = new int[]{0,0,4,2,5,0,3,0};
        for (int i : num) {
            nums.add(i);
        }
        int k = 0;
        Integer zero = new Integer(0);
        while (k < nums.size()) {
            if (nums.get(k).equals(zero))
                nums.remove(k);
            k++;
        }
        System.out.println(nums);
    }

    @Test
    public void test() {
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        System.out.println(arr1==arr2);
    }
    //precondition: nums.size() > 0
//nums contains Integer objects


}
