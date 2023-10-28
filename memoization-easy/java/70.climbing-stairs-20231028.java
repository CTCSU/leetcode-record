/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=30102
 *
 * [70] Climbing Stairs
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int pre0 = 1, pre1 = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre0 + pre1;
            pre0 = pre1;
            pre1 = cur;
        }

        return cur;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n
 * // @lcpr case=end
 * 
 */
