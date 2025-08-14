package 按照专题分类.栈;

/*
739. 每日温度
中等

给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]

示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]

示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]

提示：
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class 每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(solution(temperatures)));
    }

    private static int[] solution(int[] tempers) {
        int[] res = new int[tempers.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tempers.length; i++) {
            while (!stack.isEmpty() && tempers[i] > tempers[stack.peek()]) {
                int idx = stack.pop(); // 栈里样子上确实是保持的是单调递减
                res[idx] = i - idx; // 栈里堆的多的话会先把靠外的算出来 后面的减前面的
            }
            stack.push(i); // 栈里存下标 存下标我是真不容易想到
        }

        return res; // 后面的没有更大的用的是数组的默认值0
    }
}