package 按照专题分类.哈希;

/*
1. 两数之和
简单

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
*/

import java.util.*;

class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 7;

        // 试一下控制台输入
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入数组长度：");
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        System.out.println("请输入数组元素：");
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        System.out.println("请输入目标值：");
//        int target = sc.nextInt();

        int[] result; // 或者用List

        result = solution1(nums, target);
        System.out.println("[" + result[0] + "," + result[1]+ "]");

    }

    // O(n^2) 暴力破解
    private static int[] solution0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // O(n) 哈希表
    private static int[] solution1(int[] nums, int target) {
        // 存遍历过的数组值和下标
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cha = target - nums[i];

            if (indexMap.containsKey(cha)) {
                // 找到了就over了
                return new int[]{i, indexMap.get(cha)};
                // 或者换个顺序返回
            } else {
                // 没找到就放进去
                indexMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}