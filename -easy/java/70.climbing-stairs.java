/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=21201
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n < 3) {
            return n;
        } 

        int prev0 = 1, prev1 = 2;
        int current = 0;
        for(int i = 3; i <= n; i++){
            current = prev0 + prev1;
            prev0 = prev1;
            prev1 = current;
        }

        return current;
    }
}
// @lc code=end


