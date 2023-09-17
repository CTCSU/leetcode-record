/*
 * @lc app=leetcode.cn id=91 lang=java
 * @lcpr version=21913
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {

        char[] charArray = s.toCharArray();
        int pre = 1, pre1 = 1, curv = 0;
        int prec = 0;
        for (int i = 0; i < charArray.length; i++) {
            int currentC = charArray[i] - '0';
            int combineValue = prec * 10 + currentC;
            if (currentC == 0) {
                if (combineValue == 0 || combineValue >= 30) {
                    return 0;
                } else {
                    curv = pre;
                }
            } else {
                if (combineValue > 26) {
                    curv = pre1;
                } else if (combineValue < 10) {
                    curv = pre1;
                } else {
                    curv = pre + pre1;
                }
            }
            prec = currentC;
            pre = pre1;
            pre1 = curv;
        }
        return curv;
    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "12"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "226"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "06"\n
 * // @lcpr case=end
 * 
 */
