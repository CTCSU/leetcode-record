/*
 * @lc app=leetcode.cn id=72 lang=java
 * @lcpr version=21908
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] distance = new int[m + 1][n + 1];

        distance[0][0] = 0;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        distance[i][j] = distance[i - 1][j - 1];
                    } else {
                        distance[i][j] = Math.min(distance[i][j - 1] + 1, Math.min(distance[i - 1][j] + 1,
                                distance[i - 1][j - 1] + 1));
                    }
                }
            }
        }

        return distance[m][n];

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "horse"\n"ros"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "intention"\n"execution"\n
 * // @lcpr case=end
 * 
 */
