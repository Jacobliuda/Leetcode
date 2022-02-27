package jianzhi;

import org.junit.Test;


/**
 * @author Jacob
 * @creator 2022/2/27-19:07
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}

public class Test26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // A 树和 B 树有任一根节点为空，则直接返回 false
        if(A==null || B==null)
            return false;
        // 否则判断 以 A 结点为根节点的子树是否包含以 B 结点为根节点的树 [recur函数的功能]
        return recur(A, B) ||
                // 若不满足则递归分别以 A 结点的左右节点为根节点 执行本函数
                isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        // 若 B 为空 说明已到 B 树的末尾之后 匹配完成 返回 true
        if(B==null)
            return true;
        // 若 B 不为空 且 A 为空 说明 B 还没有匹配完 而 A 已经到末尾之后 返回 false
        else if(A==null)
            return false;
        // 若 A B 都不为空 但两节点值不相等 返回 false
        if(A.val!=B.val)
            return false;
        // 否则 开始依次判断子节点是否满足匹配
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    @Test
    public void test(){

    }


}
