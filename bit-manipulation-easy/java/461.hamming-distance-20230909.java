/*
 * @lc app=leetcode.cn id=461 lang=java
 * @lcpr version=21913
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while (result > 0) {
            if ((result & 1) == 1) {
                count++;
            }
            result >>= 1;
        }

        return count;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 1\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n1\n
 * // @lcpr case=end
 * 
 */
