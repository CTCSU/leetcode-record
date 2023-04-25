/*
 * @lc app=leetcode.cn id=461 lang=java
 * @lcpr version=21801
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int distance = 0;
        while (r > 0) {
            distance += r & 1;
            r = r >> 1;
        }

        return distance;
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
 * // 1\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 3\n1\n
 * // @lcpr case=end
 * 
 */
