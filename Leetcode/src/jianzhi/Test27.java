package jianzhi;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/2/28-17:02
 */

public class Test27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)  return null;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while(treeNodes.size()>0){
            TreeNode pop = treeNodes.pop();
            if(pop.left!=null)  treeNodes.add(pop.left);
            if(pop.right!=null) treeNodes.add(pop.right);
            TreeNode tmp = pop.left;
            pop.left = pop.right;
            pop.right = tmp;
        }
        return root;
    }

}
