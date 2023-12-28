/*
 * @lc app=leetcode.cn id=1143 lang=java
 * @lcpr version=30112
 *
 * [1143] Longest Common Subsequence
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] longest = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            char a = text1.charAt(i);
            for (int j = 0; j < n; j++) {
                char b = text2.charAt(j);
                longest[i + 1][j + 1] = Math.max(longest[i][j + 1], longest[i + 1][j]);
                if (a == b) {
                    longest[i + 1][j + 1] = Math.max(longest[i][j] + 1, longest[i][j + 1]);
                }
            }
        }

        return longest[m][n];

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "abcde"\n"ace"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abc"\n"abc"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abc"\n"def"\n
 * // @lcpr case=end
 * 
 */
