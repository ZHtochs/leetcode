package com.huawei.offer2.leetcode.editor.cn;

//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// 👍 593 👎 0

import com.huawei.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Java：最小高度树
public class P310MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new P310MinimumHeightTrees().new Solution();
        List<Integer> minHeightTrees = solution.findMinHeightTrees(6, ListNode.getIntArrays("[[3,0],[3,1],[3,2],[3,4],[5,4]]"));
        System.out.println(minHeightTrees);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(0);
                return ans;
            }
            HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>(n);
            for (int[] edge : edges) {
                if (hashMap.containsKey(edge[0])) {
                    hashMap.get(edge[0]).add(edge[1]);
                } else {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(edge[1]);
                    hashMap.put(edge[0], hashSet);
                }
                if (hashMap.containsKey(edge[1])) {
                    hashMap.get(edge[1]).add(edge[0]);
                } else {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(edge[0]);
                    hashMap.put(edge[1], hashSet);
                }
            }
            while (hashMap.size() > 2) {
                List<Integer> arrayList = new ArrayList<>(n);

                for (Integer integer : hashMap.keySet()) {
                    if (hashMap.get(integer).size() == 1) {
                        arrayList.add(integer);
                    }
                }
                for (Integer integer : arrayList) {
                    // 说明是叶子节点
                    HashSet<Integer> hashSet = hashMap.get(integer);
                    hashMap.remove(integer);
                    // 从相邻的里面删掉叶子节点
                    for (Integer integer1 : hashSet) {
                        hashMap.get(integer1).remove(integer);
                    }
                }
            }
            return new ArrayList<>(hashMap.keySet());
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}