package com.huawei.offer2.leetcode.editor.cn;

//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
// 👍 183 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

//Java：最小基因变化
public class P433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();
        String s1 = "AAAACCCC";
        String s2 = "CCCCCCCC";
        System.out.println(solution.minMutation(s1, s2, new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String start;
        String end;
        LinkedList<String> path = new LinkedList<>();
        private boolean hasResult = false;

        public int minMutation(String start, String end, String[] bank) {
            if (bank.length == 0) {
                return -1;
            }
            Set<String> collect = Arrays.stream(bank).collect(Collectors.toSet());
            if (!collect.contains(end)) {
                return -1;
            }
            char[] direction = new char[]{'A', 'C', 'G', 'T'};
            path.push(start);
            int time = 0;
            char[] temp = new char[start.length()];
            while (!path.isEmpty()) {
                time++;
                int size = path.size();
                for (int i = 0; i < size; i++) {
                    String poll = path.poll();
                    if (poll.equals(end)) {
                        return time - 1;
                    }
                    char[] chars = poll.toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        for (char c : direction) {
                            if (chars[j] == c) {
                                continue;
                            }
                            System.arraycopy(chars, 0, temp, 0, temp.length);
                            temp[j] = c;
                            String s = new String(temp);
                            if (collect.contains(s)) {
                                path.offer(s);
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}