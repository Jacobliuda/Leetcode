package jianzhi;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/3-21:14
 */

/*
* 请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

作者：Krahets
链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/990pf2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */

public class Test37 {
    // Encodes a tree to a single string.
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)  return "";
            StringBuilder s = traverse(root);
            return s.substring(0, s.length() - 1);
        }

        // 先序遍历
        public StringBuilder traverse(TreeNode node){
            StringBuilder s = new StringBuilder();
            if(node==null){
                s.append("null,");
                return s;
            }
            s.append(String.valueOf(node.val)).append(",");

            s.append(traverse(node.left));
            s.append(traverse(node.right));

            return s;
        }

        int i = 0;
        String[] split;
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data=="")    return null;
            split = data.split(",");
            TreeNode root = rebuild();
            return root;
        }

        public TreeNode rebuild(){
            if(i >= split.length || "null".equals(split[i]))   return null;
            TreeNode node = new TreeNode(Integer.parseInt(split[i]));
            i+=1;
            node.left = rebuild();
            i+=1;
            node.right = rebuild();
            return node;
        }
    }

    @Test
    public void test(){
        String s = "123456";
        System.out.println(s.substring(0,4));
    }
}
