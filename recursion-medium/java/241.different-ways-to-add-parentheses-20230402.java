import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=241 lang=java
 * @lcpr version=21801
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToComputeWithMemo(String expression) {
        List<Integer> result = memo.get(expression);
        if (null != result) {
            return result;
        }

        memo.put(expression, diffWaysToCompute(expression));
        return memo.get(expression);
    }

    private List<Integer> combineResult(List<Integer> left, List<Integer> right, char charAt) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : left) {
            for (Integer integer2 : right) {
                switch (charAt) {
                    case '-':
                        result.add(integer - integer2);
                        break;
                    case '+':
                        result.add(integer + integer2);
                        break;
                    default:
                        result.add(integer * integer2);
                }
            }
        }

        return result;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        boolean isAllNumber = true;
        for (int i = 0; i < expression.length(); i++) {
            if (!isNumber(expression.charAt(i))) {
                List<Integer> left = diffWaysToComputeWithMemo(expression.substring(0, i));
                List<Integer> right = diffWaysToComputeWithMemo(expression.substring(i + 1));
                List<Integer> combined = combineResult(left, right, expression.charAt(i));
                isAllNumber = false;
                result.addAll(combined);
            }
        }

        if (isAllNumber) {
            result.add(Integer.valueOf(expression));
        }

        return result;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
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
 * // "2-1-1"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "2*3-4*5"\n
 * // @lcpr case=end
 * 
 */
