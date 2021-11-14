//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// 👍 169 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Java：键值映射
public class P677MapSumPairs {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        TreeNode treeNode = new TreeNode(' ');

        public MapSum() {

        }

        public void insert(String key, int val) {
            char[] chars = key.toCharArray();
            TreeNode root = treeNode;
            TreeNode subRoot = buildTreeNode(chars, val);
            while (true) {
                if (!root.treeNodes.contains(subRoot)) {
                    root.treeNodes.add(subRoot);
                    return;
                }
                if (subRoot.treeNodes.isEmpty()) {
                    root.treeNodes.get(root.treeNodes.indexOf(subRoot)).value = subRoot.value;
                    return;
                }
                root = root.treeNodes.get(root.treeNodes.indexOf(subRoot));
                subRoot = subRoot.treeNodes.get(0);
            }
        }

        public int sum(String prefix) {
            char[] chars = prefix.toCharArray();
            TreeNode subRoot = buildTreeNode(chars, 0);
            TreeNode root = treeNode;
            while (true) {
                if (!root.treeNodes.contains(subRoot)) {
                    return 0;
                } else {
                    root = root.treeNodes.get(root.treeNodes.indexOf(subRoot));
                    if (subRoot.treeNodes.isEmpty()) {
                        return getAllValue(root);
                    } else {
                        subRoot = subRoot.treeNodes.get(0);
                    }
                }
            }
        }

        private TreeNode buildTreeNode(char[] chars, int val) {
            TreeNode root = new TreeNode(chars[0]);
            TreeNode temp = root;
            for (int i = 1; i < chars.length; i++) {
                TreeNode treeNode = new TreeNode(chars[i]);
                temp.treeNodes.add(treeNode);
                temp = treeNode;
            }
            temp.value = val;
            return root;
        }

        private int getAllValue(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int sum = 0;
            sum += treeNode.value;
            for (TreeNode node : treeNode.treeNodes) {
                sum += getAllValue(node);
            }
            return sum;
        }
        class TreeNode {
            char val;
            int value;
            List<TreeNode> treeNodes = new ArrayList<>();

            TreeNode(char val) {
                this.val = val;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                TreeNode treeNode = (TreeNode) o;
                return this.val == treeNode.val;
            }
        }
    }



/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}