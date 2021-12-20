package com.huawei.offer2.leetcode.editor.cn;

//在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足条件 1 和条件 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 
//输入：n = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 10⁴ 
// trust[i].length == 2 
// trust[i] 互不相同 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= n 
// 
// 👍 216 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.prefs.PreferenceChangeEvent;
import java.util.stream.Collectors;

//Java：找到小镇的法官
public class P997FindTheTownJudge {
    public static void main(String[] args) {
        Solution solution = new P997FindTheTownJudge().new Solution();
        int i = solution.findJudge(2, new int[][]{{1, 2}});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findJudge(int n, int[][] trust) {
            if (trust.length == 0 && n == 1) {
                return 1;
            }
            if (trust == null || trust.length < n - 2) {
                return -1;
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < trust.length; i++) {
                int[] ints = trust[i];
                hashMap.put(ints[1], hashMap.getOrDefault(ints[1], 0) + 1);
            }
            int judge = 0;
            int count = 0;
            for (Integer integer : hashMap.keySet()) {

                if (hashMap.get(integer) == n - 1) {
                    judge = integer;
                    count++;
                }
                if (count > 1) {
                    return -1;
                }
            }
            if (count == 0) {
                return -1;
            }
            for (int[] ints : trust) {
                if (ints[0] == judge) {
                    return -1;
                }
            }
            return judge;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}