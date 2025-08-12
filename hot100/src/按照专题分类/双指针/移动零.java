package 按照专题分类.双指针;

/*
283. 移动零
简单

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]

提示:
        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

进阶：你能尽量减少完成的操作次数吗？
*/

import java.util.Arrays;

class 移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        int[] res = solution(nums);
        System.out.println(Arrays.toString(res)); // 这个toString的得记住
    }

    // 核心思路是用双指针法：一个指针i遍历数组，另一个指针j指向下一个要放非零元素的位置。
    // 遍历时遇到非零元素就放到前面，最后把剩下的位置补零。
    private static int[] solution(int[] nums) {
        int j = 0; // 记录下一个要放非零元素的位置

        for (int i = 0; i < nums.length; i++) {
            // 遍历数组，把非零元素依次放到前面
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // 遍历完后，j 之后的位置全部赋值为0
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }

        return nums;
    }
}