/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

/*
31/31 cases passed (4 ms)
Your runtime beats 96.35 % of java submissions
Your memory usage beats 96.24 % of java submissions (44.4 MB)
 */

// @lc code=start

import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        int pop = stack.pop();
        if (pop == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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

