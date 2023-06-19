import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=318 lang=java
 * @lcpr version=21909
 *
 * [318] Maximum Product of Word Lengths
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        String[] list = Arrays.stream(words).sorted((a, b) -> b.length() - a.length()).toArray(String[]::new);

        int[] hash = new int[words.length];
        int count = 0;
        for (String s : list) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                int value = (s.charAt(i) - 'a') + 1;
                cur = cur | (1 << value);
            }
            hash[count] = cur;
            count++;
        }

        int result = 0;
        for (int i = 0; i < hash.length - 1; i++) {
            if (result >= (list[i].length() * list[i + 1].length())) {
                return result;
            }
            for (int j = i + 1; j < hash.length; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    int curResult = list[i].length() * list[j].length();
                    result = Math.max(result, curResult);
                }
            }
        }

        return result;

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
