import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean dp[] = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (length <= i) {
                    if (s.substring(0, i).endsWith(word)) {
                        dp[i] |= dp[i - length];
                    }
                }
            }

        }

        return dp[m];

    }
}
// @lc code=end
