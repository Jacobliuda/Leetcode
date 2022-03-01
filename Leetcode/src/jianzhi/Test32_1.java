package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jacob
 * @creator 2022/3/1-11:07
 */
public class Test32_1 {
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        ArrayList<Integer> integers = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            TreeNode pop = queue.pop();
            integers.add(pop.val);
            if(pop.left!=null)  queue.offer(pop.left);
            if(pop.right!=null) queue.offer(pop.right);
        }
        int length = integers.size();
        int[] ans = new int[length];
        for(int i = 0; i < length; i++)
            ans[i] = integers.get(i);
        return ans;
    }
}
