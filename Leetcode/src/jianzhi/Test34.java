package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/1-17:08
 */
public class Test34 {
    List<List<Integer>> ans = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        travese(root, target);
        return ans;
    }

    private void travese(TreeNode root, int target) {
        if(root==null)  return;
        target-=root.val;
        path.add(root.val);
        if(target==0 && root.left==null && root.right==null){
            ans.add(path);
            return;
        }
        travese(root.left, target);
        travese(root.right, target);
        path.remove(path.size()-1);
    }
}
