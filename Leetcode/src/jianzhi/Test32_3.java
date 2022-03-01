package jianzhi;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/3/1-12:22
 */
public class Test32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        ArrayList<List<Integer>> integers = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 定义flag变量用于控制某层的遍历顺序
        boolean flag=false;
        queue.offer(root);
        while(queue.size()>0){
            ArrayList<Integer> intee = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0){
                TreeNode pop = queue.pop();
                intee.add(pop.val);
                if(pop.left!=null)  queue.offer(pop.left);
                if(pop.right!=null) queue.offer(pop.right);
            }
            if(flag)
                Collections.reverse(intee);
            flag = flag?false:true;
            integers.add(intee);
        }
        return integers;
    }

    @Test
    public void test(){
        boolean flag = false;
        System.out.println(flag?false:true);
        flag = true;
        System.out.println(flag?false:true);
    }
}
