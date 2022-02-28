package jianzhi;

/**
 * @author Jacob
 * @creator 2022/2/28-19:36
 */
public class Test28 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if(a==null && b==null)
            return true;
        else if(a!=null && b!=null)
            return a.val==b.val && check(a.left,b.right) && check(a.right,b.left);
        else return false;
    }
}
