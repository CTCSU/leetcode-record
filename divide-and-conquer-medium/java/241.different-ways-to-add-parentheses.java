import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solutionb {
    private Map<String, List<Integer>> map = new HashMap<>();

    // public static void main(String[] args) {
    // Solutionn solution = new Solutionn();
    // System.out.println(solution.diffWaysToCompute("2-1-1"));
    // }

    public List<Integer> diffWaysToCompute(String expression) {

        return diffWaysToComputeWithCache(expression);

    }

    private List<Integer> diffWaysToComputeWithCache(String expression) {
        List<Integer> result = map.get(expression);
        if (null == result) {
            result = compute(expression);
            map.put(expression, result);
        }

        return result;
    }

    private List<Integer> compute(String expression) {
        boolean allNumbers = true;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char a = expression.charAt(i);
            if (a == '+' || a == '-' || a == '*') {
                List<Integer> left = diffWaysToComputeWithCache(expression.substring(0, i));
                List<Integer> right = diffWaysToComputeWithCache(expression.substring(i + 1, expression.length()));
                for (Integer integer : left) {
                    for (Integer integer2 : right) {
                        result.add(compute(integer, integer2, a));
                    }
                }
                allNumbers = false;
            }
        }

        if (allNumbers) {
            result.add(Integer.valueOf(expression));
        }

        return result;
    }

    private Integer compute(Integer integer, Integer integer2, char a) {
        switch (a) {
            case '+':
                return integer + integer2;
            case '-':
                return integer - integer2;
            case '*':
                return integer * integer2;
            default:
                throw new IllegalArgumentException(String.format("Unsupported operator: %s", a));
        }
    }
}
// @lc code=end
