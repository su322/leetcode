package 按照专题分类.二叉树;

/*
101. 对称二叉树
简单

给你一个二叉树的根节点 root ， 检查它是否轴对称。

示例 1：
1698026966-JDYPDU-image.png
输入：root = [1,2,2,3,4,4,3]
输出：true

示例 2：
1698027008-nPFLbM-image.png
输入：root = [1,2,2,null,3,null,3]
输出：false

提示：
树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */

import java.util.ArrayList;
import java.util.List;

class 对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(solution(root));
    }

    private static boolean solution(TreeNode root) {
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
//        if (left.val == right.val) return true; // 不能写这行
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val != right.val) return false;

        // 检查外侧
        boolean compareOutside = compare(left.left, right.right);
        // 检查内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    // debug 略微有点难想
    private static boolean compareDebug(TreeNode left, TreeNode right, int level) {
        if (left == null && right == null) return true;
//        if (left.val == right.val) return true; // 不能写这行
        if ((left == null && right != null) || (left != null && right == null)) return false;
        if (left.val != right.val) return false;

        // 检查外侧
        boolean compareOutside = compareDebug(left.left, right.right, level + 1);
        // 检查内侧
        boolean compareInside = compareDebug(left.right, right.left, level + 1);
        return compareOutside && compareInside;
    }
}