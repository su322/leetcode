package 按照专题分类.二叉树;

/*
199. 二叉树的右视图
中等

给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1：
输入：root = [1,2,3,null,5,null,4]
输出：[1,3,4]
解释：
tmpd5jn43fs-1.png

示例 2：
输入：root = [1,2,3,4,null,null,null,5]
输出：[1,3,4,5]
解释：
tmpkpe40xeh-1.png

示例 3：
输入：root = [1,null,3]
输出：[1,3]
示例 4：
输入：root = []
输出：[]

提示:
二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 二叉树的右视图 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(solution(root));
    }

    // 层序遍历 迭代 借助队列 的思路 稍微有点难想
    private static List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();

        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            int levelSize = que.size(); // 想明白levelSize的含义就理解了

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.poll();

                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }

                if (i == levelSize - 1) {
                    // levelSize就是一层的所有结点的个数 levelSize-1 刚好是最右边的那个
                    // 等左边的全部出去了就轮到他了
                    res.add(poll.val);
                }
            }
        }

        return res;
    }
}