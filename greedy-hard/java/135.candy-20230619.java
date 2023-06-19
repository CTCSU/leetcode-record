import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 * @lcpr version=21908
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] >= ratings[i]) {
                candies[i] = 1;
            } else {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }

        return Arrays.stream(candies).reduce(0, (a, b) -> a + b);

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,0,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,2]\n
 * // @lcpr case=end
 * 
 */
