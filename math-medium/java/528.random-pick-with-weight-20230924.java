import java.util.Random;

/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=21914
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {

    int[] w;
    Random random = new Random();

    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }

    }

    public int pickIndex() {
        int val = (int) Math.floor(Math.random() * w[w.length - 1]) + 1;
        int l = 0, r = w.length;
        int ans = 0;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (w[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
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
