package 按照专题分类.二叉树;

/*
102. 二叉树的层序遍历
中等

给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

示例 1：
tree1.jpg
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

示例 2：
输入：root = [1]
输出：[[1]]

示例 3：
输入：root = []
输出：[]

提示：
树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000
 */


import java.util.ArrayList;
import java.util.List;

class 二叉树的层序遍历 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
        TreeNode root = null;
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        System.out.println(solution(root));
    }

    // 目前感觉迭代法好想一点
    private static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return null;

        return res;
    }
}