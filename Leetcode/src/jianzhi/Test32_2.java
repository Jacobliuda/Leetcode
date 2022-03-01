package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/1-12:07
 */
public class Test32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        ArrayList<List<Integer>> integers = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            ArrayList<Integer> intee = new ArrayList<>();
//            LinkedList<TreeNode> tmp = new LinkedList<>();
//            while(queue.size()>0)
//                tmp.offer(queue.pop());
//            while(tmp.size()>0){
//                TreeNode pop = tmp.pop();
//                intee.add(pop.val);
//                if(pop.left!=null)  queue.offer(pop.left);
//                if(pop.right!=null) queue.offer(pop.right);
//            }

            int size = queue.size();
            while(size-- > 0){
                TreeNode pop = queue.pop();
                intee.add(pop.val);
                if(pop.left!=null)  queue.offer(pop.left);
                if(pop.right!=null) queue.offer(pop.right);
            }

            integers.add(intee);
        }
        return integers;
    }
}
