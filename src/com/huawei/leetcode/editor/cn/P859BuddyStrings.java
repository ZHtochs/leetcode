//给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。 
//
// 
// 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab", goal = "ba"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。 
//
// 示例 2： 
//
// 
//输入：s = "ab", goal = "ab"
//输出：false
//解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。 
//
// 示例 3： 
//
// 
//输入：s = "aa", goal = "aa"
//输出：true
//解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
// 
//
// 示例 4： 
//
// 
//输入：s = "aaaaaaabc", goal = "aaaaaaacb"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, goal.length <= 2 * 10⁴ 
// s 和 goal 由小写英文字母组成 
// 
// 👍 232 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

//Java：亲密字符串
public class P859BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new P859BuddyStrings().new Solution();
        System.out.println(solution.buddyStrings("ab", "ba"));
        System.out.println(solution.buddyStrings("Ab", "Ab"));
        System.out.println(solution.buddyStrings("aa", "aa"));
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            char[] chars = s.toCharArray();
            char[] goalChars = goal.toCharArray();
            HashSet<Integer> hashSet = new HashSet<>();
            HashMap<Character, Integer> hashMap = new HashMap();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != goalChars[i]) {
                    hashSet.add(i);
                } else {
                    hashMap.put(chars[i], hashMap.getOrDefault(chars[i], 0) + 1);
                }
            }
            int sameCount = 0;
            for (Character character : hashMap.keySet()) {
                if (hashMap.get(character) >= 2) {
                    sameCount++;
                }
            }
            if (hashSet.size() == 0 && sameCount >= 1) {
                return true;
            }
            if (hashSet.size() != 2) {
                return false;
            }

            int[] integers = hashSet.stream().mapToInt(Integer::intValue).toArray();
            return chars[integers[0]] == goalChars[integers[1]]
                    && chars[integers[1]] == goalChars[integers[0]];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}