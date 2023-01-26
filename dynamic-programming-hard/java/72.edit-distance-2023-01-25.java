import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Arrays.asList(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]).stream()
                                .min(Integer::compare).get()
                                + 1;
                    }
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end
