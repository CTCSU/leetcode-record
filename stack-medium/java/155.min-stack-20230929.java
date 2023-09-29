import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=155 lang=java
 * @lcpr version=21917
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    LinkedList<Integer> queue = new LinkedList<>();
    LinkedList<Integer> minQueue = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        queue.push(val);
        if (minQueue.size() > 0 && minQueue.peek() < val) {
            minQueue.push(minQueue.peek());
        } else {
            minQueue.push(val);
        }

    }

    public void pop() {
        if (queue.size() > 0) {
            queue.pop();
            minQueue.pop();
        }
    }

    public int top() {
        return queue.peek();
    }

    public int getMin() {
        return minQueue.peek();
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
