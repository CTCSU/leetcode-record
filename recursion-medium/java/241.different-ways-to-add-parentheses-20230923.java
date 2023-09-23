import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=241 lang=java
 * @lcpr version=21914
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    private String expression;

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;

        char[] chars = expression.toCharArray();
        return getSubResult(chars, 0, chars.length - 1);
    }

    List<Integer> getSubResult(char[] a, int i, int j) {
        List<Integer> result = new ArrayList<>();
        if (i == j) {
            result.add(Integer.valueOf(String.valueOf(a[i])));
            return result;
        }

        boolean hasOperator = false;

        for (int k = i; k <= j; k++) {
            char val = a[k];

            List<Integer> leftResult = new ArrayList<>();
            List<Integer> rightResult = new ArrayList<>();
            if (isOperator(val)) {
                hasOperator = true;
                leftResult.addAll(getSubResult(a, i, k - 1));
                rightResult.addAll(getSubResult(a, k + 1, j));
            }

            for (Integer l : leftResult) {
                for (Integer r : rightResult) {
                    result.add(calculate(val, l, r));
                }
            }
        }

        if (!hasOperator) {
            result.add(Integer.valueOf(expression.substring(i, j + 1)));
        }

        return result;
    }

    private boolean isOperator(char a) {
        return a == '+' || a == '-' || a == '*';
    }

    private Integer calculate(char a, Integer l, Integer r) {

        switch (a) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            default:
                return l * r;
        }

    }

}
// @lc code=end

/*
 * // @lcpr case=start
 * // "2-1-1"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2*3-4*5"\n
 * // @lcpr case=end
 * 
 */
