package 按照专题分类.栈;

/*
20. 有效的括号
简单

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([])"
输出：true

示例 5：
输入：s = "([)]"
输出：false

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */

import java.util.ArrayDeque;
import java.util.Deque;

class 有效的括号 {
    public static void main(String[] args) {
        String str = "()[]{}";

        System.out.println(solution(str));
    }
    
    private static boolean solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')'); // 碰到左括号，就把相应的右括号入栈
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false; // 开头不是左括号，或者右括号和栈中的不匹配
            } else {
                // 碰到右括号 右括号是否正确在上面判断了
                stack.pop();
            }
        }
        return stack.isEmpty(); // 遍历完栈为空证明匹配完了，false的条件在上面判断了
    }
}