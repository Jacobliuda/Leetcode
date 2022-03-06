package jianzhi;

/**
 * @author Jacob
 * @creator 2022/3/4-8:47
 */
public class Test54 {
    int i;
    int ans;
    public int kthLargest(TreeNode root, int k) {
        i = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node){
        dfs(node.right);
        if(node==null)  return;
        if(i==1)
            ans = node.val;
        i--;
        dfs(node.left);
    }
}
