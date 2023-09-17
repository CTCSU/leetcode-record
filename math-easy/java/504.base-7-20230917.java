/*
 * @lc app=leetcode.cn id=504 lang=java
 * @lcpr version=21913
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        boolean lessZero = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        return lessZero ? "-" + sb.reverse().toString() : sb.reverse().toString();

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 100\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // -7\n
 * // @lcpr case=end
 * 
 */
