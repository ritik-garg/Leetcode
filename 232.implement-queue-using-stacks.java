/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

/*
23/23 cases passed (2 ms)
Your runtime beats 16.05 % of java submissions
Your memory usage beats 83.9 % of java submissions (42.1 MB)
*/

// @lc code=start

import java.util.Stack;

class MyQueue {
    Stack<Integer> s;
    Stack<Integer> t;

    public MyQueue() {
        s = new Stack<>();
        t = new Stack<>();
    }
    
    public void push(int x) {
        while (!s.empty()) {
            t.push(s.pop());
        }
        s.push(x);
        while (!t.empty()) {
            s.push(t.pop());
        }
    }
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() {
        return s.peek();
    }
    
    public boolean empty() {
        return s.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

