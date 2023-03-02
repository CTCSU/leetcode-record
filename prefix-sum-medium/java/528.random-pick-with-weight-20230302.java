/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=21705
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {

    private int[] prefix_sum;
    private int max;
    private int lastIndex;

    public Solution(int[] w) {
        this.lastIndex = w.length - 1;
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.prefix_sum = w;
        this.max = w[lastIndex];
    }

    public int pickIndex() {
        int random = (int) (Math.random() * max) + 1;
        int l = 0, r = lastIndex;
        int ans = 0;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (prefix_sum[mid] >= random) {
                r = mid - 1;
                ans = mid;
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
