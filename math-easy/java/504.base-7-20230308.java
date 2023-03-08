/*
 * @lc app=leetcode.cn id=504 lang=java
 * @lcpr version=21705
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean biggerThan0 = num >= 0;
        int absNum = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (absNum > 0) {
            sb.append(absNum % 7);
            absNum = absNum / 7;
        }

        String absResult = sb.reverse().toString();
        return biggerThan0 ? absResult : "-" + absResult;

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

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
