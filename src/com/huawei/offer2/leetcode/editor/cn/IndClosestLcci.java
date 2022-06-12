package com.huawei.offer2.leetcode.editor.cn;

//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// 👍 82 👎 0

import java.util.ArrayList;

//Java：单词距离
public class IndClosestLcci {
    public static void main(String[] args) {
        Solution solution = new IndClosestLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    arrayList1.add(i);
                } else if (words[i].equals(word2)) {
                    arrayList2.add(i);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arrayList1.size(); i++) {
                int pos1 = arrayList1.get(i);
                for (int j = 0; j < arrayList2.size(); j++) {
                    int pos2 = arrayList2.get(i);
                    min = Math.min(min, Math.abs(pos1 - pos2));
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}