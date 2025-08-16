package 按照专题分类.二叉树;

/*
104. 二叉树的最大深度
简单

给定一个二叉树 root ，返回其最大深度。
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

示例 1：
tmp-tree.jpg
输入：root = [3,9,20,null,null,15,7]
输出：3

示例 2：

输入：root = [1,null,2]
输出：2

提示：
树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
 */

import java.util.ArrayDeque;
import java.util.Queue;

class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution(root));
    }

    // 最大深度就是层数 层序遍历的时候记录一下就行 还是迭代 借助队列 如果隔一段时间不写估计就忘了
    private static int solution(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();
//            depth++; // 放这结果一样 如果是最小深度就必须得放前面了，因为while里如果根节点没有孩子就直接返回了
            while (levelSize > 0) {
                TreeNode poll = que.poll();

                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
                levelSize--;
            }
            depth++;
        }
        return depth;
    }
}