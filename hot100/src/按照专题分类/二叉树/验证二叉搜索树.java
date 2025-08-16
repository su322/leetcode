package 按照专题分类.二叉树;

/*
98. 验证二叉搜索树
中等

给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例 1：
tree1-.jpg
输入：root = [2,1,3]
输出：true

示例 2：
tree2-.jpg
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。

提示：
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
 */

import java.util.ArrayList;
import java.util.List;

class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(solution(root));
    }

    // 二叉搜索树中序遍历的结果应该是递增的 可以拿到遍历后的结果看是否有序
    // 或者在递归的过程中直接比较前一个节点值 但要复杂一点
    private static boolean solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return isSorted(list);
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) { // 第二个开始
//            if (list.get(i) > list.get(i - 1)) return true; // 二叉搜索树不能有重复值 不能这么写 如果是二叉搜索树应该全判断完才能返回true 而不是一次就返回了
            if (list.get(i) <= list.get(i - 1)) return false; // 二叉搜索树不能有重复值 这么写才是对的 有不对的就返回 但是全是正确的得全部判断了才行
        }
//        return false;
        return true;
    }
}