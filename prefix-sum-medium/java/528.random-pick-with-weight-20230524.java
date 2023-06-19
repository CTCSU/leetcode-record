/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=21801
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {

    private int[] w;

    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int max = w[w.length - 1];
        int random = (int) (Math.random() * max) + 1;

        int l = 0, r = w.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (w[mid] < random) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
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
