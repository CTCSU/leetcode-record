/*
 * @lc app=leetcode.cn id=504 lang=java
 * @lcpr version=21912
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        int absNum = Math.abs(num);
        StringBuffer sb = new StringBuffer();
        while (absNum != 0) {
            int x = absNum % 7;
            sb.append(x);
            absNum = absNum / 7;
        }

        return num > 0 ? sb.reverse().toString() : "-" + sb.reverse().toString();
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
