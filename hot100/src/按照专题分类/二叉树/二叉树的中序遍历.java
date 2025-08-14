package 按照专题分类.二叉树;

/*
94. 二叉树的中序遍历
简单

给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

示例 1：
inorder_1.jpg
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import java.util.ArrayList;
import java.util.List;

class 二叉树的中序遍历 {
    public static void main(String[] args) {
        // 构造树：root = [1, null, 2, 3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(solution(root));
    }

    private static List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}