/*
 * @lc app=leetcode.cn id=91 lang=java
 * @lcpr version=21401
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        Integer prev = s.charAt(0) - '0';
        int prevR = 1, prev1R = 1;
        int curR = 1;

        for (int i = 1; i < s.length(); i++) {
            Integer cur = s.charAt(i) - '0';
            int value = cur + prev * 10;
            if (cur == 0) {
                if (value == 0 || value > 20) {
                    return 0;
                } else {
                    curR = prevR;
                }
            } else if (value >= 10 && value <= 26) {
                curR = prev1R + prevR;
            } else {
                curR = prev1R;
            }

            prevR = prev1R;
            prev1R = curR;
            prev = cur;
        }

        return curR;
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
