import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=318 lang=java
 * @lcpr version=30112
 *
 * [318] Maximum Product of Word Lengths
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxProduct(String[] words) {

        Arrays.sort(words, (t1, t2) -> t2.length() - t1.length());

        int[] convertResult = Arrays.stream(words).mapToInt(t -> {
            int result = 0;
            for (char c : t.toCharArray()) {
                int left = c - 'a';
                int shift = 1 << left;
                result = result | shift;
            }
            return result;
        }).toArray();

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((convertResult[i] & convertResult[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // ["abcw","baz","foo","bar","xtfn","abcdef"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["a","ab","abc","d","cd","bcd","abcd"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["a","aa","aaa","aaaa"]\n
 * // @lcpr case=end
 * 
 */
