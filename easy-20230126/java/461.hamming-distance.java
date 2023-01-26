/*
 * @lc app=leetcode.cn id=461 lang=java
 * @lcpr version=21201
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        int count = 0;
        while (value > 0) {
            count += value & 1;
            value = value >> 1;
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
