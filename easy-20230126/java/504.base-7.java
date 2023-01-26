/*
 * @lc app=leetcode.cn id=504 lang=java
 * @lcpr version=21201
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean smallerThanZero = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        if (smallerThanZero) {
            sb.append("-");
        }

        return sb.reverse().toString();
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
