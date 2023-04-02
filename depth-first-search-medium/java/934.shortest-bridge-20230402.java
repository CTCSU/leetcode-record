import java.util.LinkedList;
import java.util.List;

/*
* @lc app=leetcode.cn id=934 lang=java
* @lcpr version=21801
*
* [934] Shortest Bridge
*/

// @lc code=start
class Solution {
private int m;
private int n;
private int[][] matrix;
private int[] shift = new int[] { -1, 0, 1, 0, -1 };
LinkedList<List<Integer>> stack = new LinkedList<>();

        private void init(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
        }

        private boolean isValid(int i, int j) {
        return i >= 0 && i < this.m && j>= 0 && j < this.n; } public int shortestBridge(int[][] grid) { init(grid);
                boolean continueSearch=true; for (int i=0; i < m && continueSearch; i++) { for (int j=0; j < n &&
                continueSearch; j++) { if (matrix[i][j]==1) { dfs(i, j); continueSearch=false; } } } int result=0; while
                (!stack.isEmpty()) { int count=stack.size(); while (count--> 0) {
                List<Integer> s = stack.removeFirst();
                    int i = s.get(0), j = s.get(1);
                    for (int x = 0; x < 4; x++) { int ni=i + shift[x], nj=j + shift[x + 1]; if (isValid(ni, nj)) {
                        switch (matrix[ni][nj]) { case 1: return result; case 0:
                        matrix[ni][nj]=stack.addLast(List.of(ni, nj)); break; default: break; } } } } result++; } return
                        result; } private void dfs(int i, int j) { matrix[i][j]=2; stack.push(List.of(i, j)); for (int
                        x=0; x < 4; x++) { int ni=i + shift[x], nj=j + shift[x + 1]; if (isValid(ni, nj) &&
                        matrix[ni][nj]==1) { dfs(ni, nj); } } } } // @lc code=end // @lcpr-div-debug-arg-start //
funName=// paramTypes=[] // returnType=// @lcpr-div-debug-arg-end /* * // @lcpr
        // case=start * //
[[0,1],[1,0]]\n* // @lcpr case=end * * // @lcpr case=start * // [[0,1,0],[0,0,0],[0,0,1]]\n *
// @lcpr case=end * * // @lcpr case=start * //
[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]\n* // @lcpr case=end * */