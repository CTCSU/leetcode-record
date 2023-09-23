import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=155 lang=java
 * @lcpr version=21914
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    private LinkedList<Integer> linkedList = new LinkedList<>();
    private LinkedList<Integer> minumValueList = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        linkedList.push(val);

        if (minumValueList.size() > 0 && val > minumValueList.getLast()) {
            minumValueList.add(minumValueList.getLast());
        } else {
            minumValueList.add(val);
        }

    }

    public void pop() {
        if (linkedList.size() != 0) {
            linkedList.pop();
            minumValueList.removeLast();
        }
    }

    public int top() {
        return linkedList.getFirst();
    }

    public int getMin() {
        return minumValueList.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
