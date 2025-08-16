package 按照专题分类.二叉树;

/*
226. 翻转二叉树
简单

给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

示例 1：
invert1-tree.jpg
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

示例 2：
invert2-tree.jpg
输入：root = [2,1,3]
输出：[2,3,1]

示例 3：
输入：root = []
输出：[]

提示：
树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100
 */

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(solution2(root)); // 返回根节点就行
    }

    // 递归 前序遍历后序遍历都可以 中序遍历这么做有问题 要额外改
    private static TreeNode solution1(TreeNode root) {
        return preOrder(root);
    }

    // 可以合并到上面，因为没有其他操作了
    private static TreeNode preOrder(TreeNode root) {
        if (root == null) return root;

        preOrder(root.left);
        preOrder(root.right);
        swapChildren(root);
        return root;
    }

    private static void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

/// ==============================================================

    // 迭代 层序遍历 借助队列
    private static TreeNode solution2(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();
            while (levelSize > 0) {
                TreeNode poll = que.poll();
                swapChildren(poll);
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
                levelSize--;
            }
        }

        return root;
    }
}