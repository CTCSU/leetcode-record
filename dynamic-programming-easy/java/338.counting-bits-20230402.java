/*
 * @lc app=leetcode.cn id=338 lang=java
 * @lcpr version=21801
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                result[i] = result[i >> 1] + 1;
            } else {
                result[i] = result[i >> 1];
            }
        }
        return result;
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
 * // 2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 5\n
 * // @lcpr case=end
 * 
 */
