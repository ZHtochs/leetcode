//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// 👍 370 👎 0

package com.huawei.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Java：添加与搜索单词 - 数据结构设计
public class P211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        System.out.println("ASD".matches("..D"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        private final HashMap<Integer, Set<String>> hashMap;

        public WordDictionary() {
            hashMap = new HashMap<>();
        }

        public void addWord(String word) {
            int length = word.length();
            if (hashMap.containsKey(length)) {
                hashMap.get(length).add(word);
            } else {
                Set<String> strings = new HashSet<>();
                strings.add(word);
                hashMap.put(length, strings);
            }
        }

        public boolean search(String word) {
            int length = word.length();
            if (!hashMap.containsKey(length)) {
                return false;
            }
            Set<String> strings = hashMap.get(word.length());
            for (String string : strings) {
                if (string.matches(word)) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}