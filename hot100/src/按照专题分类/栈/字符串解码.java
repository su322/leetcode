package 按照专题分类.栈;

/*
394. 字符串解码
中等

给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
测试用例保证输出的长度不会超过 105。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

提示：
1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300]
 */

import java.util.ArrayDeque;
import java.util.Deque;

class 字符串解码 {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";

        System.out.println(solution(str));
    }

    /*
    你用的是String cur = cur + c;和StringBuilder temp = new StringBuilder(strs.pop()); temp.append(cur);
    ，每次拼接字符串都会新建对象，尤其是在多次重复和嵌套时，频繁创建和复制字符串，导致性能下降。
    如果用StringBuilder来维护cur，每次直接append字符和片段，效率会高很多，
    因为StringBuilder是可变的，减少了对象创建和内存复制。
     */
    private static String solution(String str) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> strs = new ArrayDeque<>();
        String cur = "";
        int k = 0; // 需要重复的倍数，因为可能是多位数所以下面要算一下

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                // 遇到数字
                k = k * 10 + (c - '0'); // c是char，不是int，所以要算一下，并且可能有多位，可以用num暂存
            } else if (c == '[') {
                nums.push(k); // 倍数进栈，先遇到的数字后用
                strs.push(cur); // 存的是前面的，后面的在 ] 加倍的时候取出来加在他后面，如果还有 [] 就再进栈，重复
                cur = "";
                k = 0;
            } else if (c == ']') {
                int repeat = nums.pop();
                StringBuilder temp = new StringBuilder(strs.pop());
                for (int i = 0; i < repeat; i++) {
                    temp.append(cur);
                }
                cur = temp.toString(); // 下一步如果遇到 [ 就该进栈了，如果遇到 ] 就把他弹出来，该加倍的自己加倍，最后拼在后面
            } else {
                // 遇到字母
                cur = cur + c; // 最后在 ] 之前的字符串要被拿来加倍
            }
        }

        return cur;
    }
}