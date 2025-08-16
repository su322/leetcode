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


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
//        TreeNode root = null;
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution(root));
    }

    // 目前感觉迭代法好想一点，借助队列
    private static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root); // 队列和栈的操作还是区分开吧，虽然ArrayDeque同时实现了Queue和Deque接口

        while (!que.isEmpty()) { // 只要有孩子就会源源不断的放进队列，队列空了说明下面什么都没有了
            List<Integer> itemList = new ArrayList<>();
            int levelSize = que.size(); // 用来界定不同层的依据

            while (levelSize > 0) { // size没了说明这层放入队列的数量耗尽了，跟新放的下一层的没关系
                TreeNode temp = que.poll();
                itemList.add(temp.val);

                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
                levelSize--;
            }
            res.add(itemList); // 这层的结点List添加进结果，如果新放的有就继续下一层了，这层的出去完了，重新算下一层的size
        }

        return res;
    }
}