/*
 * @lc app=leetcode.cn id=413 lang=java
 * @lcpr version=21913
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0, curAccumulator = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == nums[i] - nums[i - 1]) {
                curAccumulator++;
                count += curAccumulator;
            } else {
                curAccumulator = 0;
            }
        }

        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
