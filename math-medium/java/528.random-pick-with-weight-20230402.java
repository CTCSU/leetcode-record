/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=21801
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {

    private int[] prefix_sum;
    private int max;

    public Solution(int[] w) {
        prefix_sum = new int[w.length];
        int pre = 0;
        for (int i = 0; i < w.length; i++) {
            pre = pre + w[i];
            prefix_sum[i] = pre;
        }
        max = pre;
    }

    public int pickIndex() {
        int random = (int) (Math.floor(Math.random() * max)) + 1;
        int l = 0, r = prefix_sum.length - 1;
        int result = 0;
        while (l <= r) {
            int mid = (int) Math.floor((r - l) / 2) + l;
            if (prefix_sum[mid] == random) {
                return mid;
            } else if (prefix_sum[mid] < random) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }

        return result;
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
