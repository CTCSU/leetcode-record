/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=21705
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {

    private int[] preSum;
    private final int MAX_VALUE;

    public Solution(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.preSum = w;
        MAX_VALUE = w[w.length - 1];
    }

    public int pickIndex() {
        int random = (int) (Math.floor(Math.random() * MAX_VALUE) + 1);
        int l = 0, r = preSum.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (int) (l + Math.floor((r - l) / 2));
            if (preSum[mid] >= random) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end
