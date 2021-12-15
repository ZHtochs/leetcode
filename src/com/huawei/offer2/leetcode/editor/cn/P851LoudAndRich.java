package com.huawei.offer2.leetcode.editor.cn;

//有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号
//为 x 的人简称为 "person x "。 
//
// 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组
// quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 
//person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。 
//
// 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，
//person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。 
//
// 
//
// 示例 1： 
//
// 
//输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//输入： [0,1,2,3,4,5,6,7]
//输出： [5,5,2,5,4,5,6,7]
//解释： 
//answer[0] = 5，
//person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
//
//唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
//但是目前还不清楚他是否比 person 0 更有钱。
//answer[7] = 7，
//在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
//最安静（有较低安静值 quiet[x]）的人是 person 7。
//其他的答案也可以用类似的推理来解释。
// 
//
// 示例 2： 
//
// 
//输入：richer = [], quiet = [0]
//输出：[0]
// 
// 
//
// 提示： 
//
// 
// n == quiet.length 
// 1 <= n <= 500 
// 0 <= quiet[i] < n 
// quiet 的所有值 互不相同 
// 0 <= richer.length <= n * (n - 1) / 2 
// 0 <= ai, bi < n 
// ai != bi 
// richer 中的所有数对 互不相同 
// 对 richer 的观察在逻辑上是一致的 
// 
// 👍 166 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：喧闹和富有
public class P851LoudAndRich {
    public static void main(String[] args) {
        Solution solution = new P851LoudAndRich().new Solution();
        // TO TEST
        int[][] ints = ListNode.getIntArrays("[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]");
        int[] ints1 = solution.loudAndRich(ints, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        System.out.println("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        HashMap<Richer, Richer> hashMap = new HashMap<>();

        int[] quiet;

        public int[] loudAndRich(int[][] richer, int[] quiet) {
            Richer[] richers = new Richer[quiet.length];
            this.quiet = quiet;
            for (int i = 0; i < richers.length; i++) {
                richers[i] = new Richer(i);
            }
            for (int i = 0; i < richer.length; i++) {
                int[] temp = richer[i];
                int poor = temp[1];
                int rich = temp[0];
                richers[poor].list.add(richers[rich]);
            }
            int[] res = new int[quiet.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = dsf(richers[i]).id;
            }
            return res;
        }

        private Richer dsf(Richer richer) {
            if (hashMap.containsKey(richer)) {
                return hashMap.get(richer);
            }
            if (richer.list.isEmpty()) {
                System.out.println("put self " + richer + " temp " + richer);
                hashMap.put(richer, richer);
                return richer;
            }
            Richer temp = richer;
            for (Richer richer1 : richer.list) {
                Richer richer2 = dsf(richer1);
                int min2 = quiet[richer2.id];
                temp = quiet[temp.id] < min2 ? temp : richer2;
            }
            System.out.println("put " + richer + " temp " + temp);
            hashMap.put(richer, temp);
            return temp;
        }

        private class Richer {
            int id;
            List<Richer> list = new ArrayList<>();

            public Richer(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "Richer{" +
                        "id=" + id +
                        '}';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}