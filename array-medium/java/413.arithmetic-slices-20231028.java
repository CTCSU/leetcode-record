/*
 * @lc app=leetcode.cn id=413 lang=java
 * @lcpr version=30102
 *
 * [413] Arithmetic Slices
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }

        int count = 0;
        int accumulate = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                accumulate++;
                count += accumulate;
            } else {
                accumulate = 0;
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
