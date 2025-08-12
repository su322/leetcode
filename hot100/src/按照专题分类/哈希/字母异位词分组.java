package 按照专题分类.哈希;

/*
49. 字母异位词分组
中等

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

解释：
在 strs 中没有字符串可以通过重新排列来形成 "bat"。
字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]

提示：
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
 */

import java.util.*;

class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> res;

        res = solution0(strs);
        System.out.println(res.values());
    }

    // 计数法 O(n * k) 每个字符串最大长度为k
    private static Map<String, List<String>> solution0(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        // 遍历每个数组元素
        for (String str : strs) {
            // 多个异位词都有唯一字母计数，用它作为key
            int[] record = new int[26];
            // 遍历每个字符串字符
            for (int i = 0; i < str.length(); i++) {
                // 相当于得到了一个key
                record[str.charAt(i) - 'a']++;
            }
            // 数组转成String
            String key = Arrays.toString(record);

            // 接下来存到结果map里
            // 如果key之前已经添加过，就把str添加到对应的列表里
            if (res.containsKey(key)) {
                res.get(key).add(str);
            } else {
                // 如果没添加过，就创建新List并添加str再put
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(key, list);
            }
        }

        return res;
    }

    // 排序法，就是要记得String转成字符数组的方法
    // O(n * k * logk) 每个字符串排序 O(k * logk)
    private static Map<String, List<String>> solution1(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            // 对每个字符串的字符排序，作为key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 接下来存到结果map里
            // 如果key之前已经添加过，就把str添加到对应的列表里
            if (res.containsKey(key)) {
                res.get(key).add(str);
            } else {
                // 如果没添加过，就创建新List并添加str再put
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(key, list);
            }
        }

        return res;
    }
}