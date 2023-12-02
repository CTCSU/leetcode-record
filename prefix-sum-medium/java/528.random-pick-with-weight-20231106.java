import java.util.Random;

/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=30103
 *
 * [528] Random Pick with Weight
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {

    int[] w;
    int max;

    Random random = new Random(System.currentTimeMillis());

    public Solution(int[] w) {

        for (int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }

        this.w = w;
        max = w[w.length - 1];
    }

    public int pickIndex() {

        int val = random.nextInt(this.max) + 1;
        int l = 0, r = w.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (w[mid] >= val) {
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
