package jianzhi;

/**
 * @author Jacob
 * @creator 2022/3/3-19:25
 */

/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class Test36 {
    // 初始化变量 pre 用于动态指向前序结点；head 用于指向头结点
    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null)  return root;
        traverse(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void traverse(TreeNode node){
        // node 结点为空 表面已到叶子结点以下 直接返回
        if(node==null)   return;

        // 常规中序遍历步骤：最先遍历左子节点
        traverse(node.left);

        // 本次递归算法
        // 如果 pre 为空 说明此时的 node 是最小值结点 将 head 指向它
        if(pre==null)
            head=node;

        // 如果 pre 不为空 则将 pre 和当前结点互相指向
        else{
            pre.right=node;
            node.left = pre;
        }

        // 更新 pre
        pre = node;

        // 常规中序遍历步骤：最后遍历右子节点
        traverse(node.right);
    }
}
