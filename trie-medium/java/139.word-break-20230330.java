import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=21705
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean[] canBreak = new boolean[m + 1];
        canBreak[0] = true;
        for (int j = 1; j <= m; j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                String currentWord = wordDict.get(i);
                int curLength = currentWord.length();
                if (j >= curLength) {
                    if (s.substring(j - curLength, j).equals(currentWord)) {
                        canBreak[j] |= canBreak[j - curLength];
                    }
                }
            }
        }

        return canBreak[m];

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // "leetcode"\n["leet","code"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "applepenapple"\n["apple","pen"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "catsandog"\n["cats","dog","sand","and","cat"]\n
 * // @lcpr case=end
 * 
 */
