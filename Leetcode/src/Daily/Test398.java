package Daily;

import java.util.Random;

/**
 * @author Jacob
 * @creator 2022/4/25-19:26
 * @description
 */
class Test398 {
    int[] nums;
    Random random = new Random(100);
    public Test398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int idx = 0;
        int cnt = 0;
        for(int i = 0; i < this.nums.length; i++){
            if(this.nums[i] == target){
                cnt++;
                if(random.nextInt(cnt) == 0)
                    idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Test398 test398 = new Test398(new int[]{1, 2, 3, 3, 3});
        System.out.println(test398.pick(3));

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
