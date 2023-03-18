import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=318 lang=java
 * @lcpr version=21705
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int[] bitWords = new int[words.length];
        for (int i = 0; i < bitWords.length; i++) {
            String word = words[i];
            bitWords[i] = word.chars().reduce(0, (a, b) -> a | (1 << (b - 'a')));
        }

        int maxValue = 0;
        for (int i = 0; i < bitWords.length; i++) {
            for (int j = i + 1; j < bitWords.length; j++) {
                if (0 == (bitWords[i] & bitWords[j])) {
                    maxValue = Math.max(maxValue, words[i].length() * words[j].length());
                    if (i == bitWords.length - 2 || words[i + 1].length() * words[i + 2].length() <= maxValue) {
                        return maxValue;
                    }
                }
            }
        }

        return maxValue;

    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * @lcpr case=start
 * ["abcw","baz","foo","bar","xtfn","abcdef"]\n
 * 
 * @lcpr case=end
 * 
 * @lcpr case=start
 * ["a","ab","abc","d","cd","bcd","abcd"]\n
 * 
 * @lcpr case=end
 * 
 * @lcpr case=start
 * ["a","aa","aaa","aaaa"]\n
 * // @lcpr case=end
 * 
 */
