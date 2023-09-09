/*
 * @lc app=leetcode.cn id=69 lang=java
 * @lcpr version=21913
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int l = 1, r = x / 2;
        int result = x;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            int value = x / mid;
            if (mid <= value) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 8\n
 * // @lcpr case=end
 * 
 */
