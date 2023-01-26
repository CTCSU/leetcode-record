/*
 * @lc app=leetcode.cn id=69 lang=java
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
        int ans = 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid <= x / mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
// @lc code=end
