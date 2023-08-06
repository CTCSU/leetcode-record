/*
 * @lc app=leetcode.cn id=136 lang=java
 * @lcpr version=21913
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,1,2,1,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
