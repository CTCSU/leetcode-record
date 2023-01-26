/*
 * @lc app=leetcode.cn id=338 lang=java
 * @lcpr version=21201
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            result[index] = result[index >> 1] + (int) (index & 1);

        }

        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 */
