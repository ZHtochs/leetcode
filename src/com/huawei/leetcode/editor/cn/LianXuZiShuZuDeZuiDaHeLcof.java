package com.huawei.leetcode.editor.cn;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 362 👎 0


public class LianXuZiShuZuDeZuiDaHeLcof{
	public static void main(String[] args) {
		Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		int max = nums[0];
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			cur = Math.max(cur + nums[i], nums[i]);
			max = Math.max(max, cur);
		}
		return max;
    }

    // 注意，是以cMax表示的是以当前结尾的子序列的最大值。表示的对之后的贡献
//	public int maxSubArray(int[] nums) {
//		int length = nums.length;
//		int cMax = 0, mMax = nums[0];
//		for (int i = 0; i < length; i++) {
//			cMax = Math.max(nums[i], cMax + nums[i]);
//			mMax = Math.max(cMax, mMax);
//		}
//		return mMax;
//	}
}
//leetcode submit region end(Prohibit modification and deletion)

}