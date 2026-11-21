/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

/*
59/59 cases passed (5 ms)
Your runtime beats 53.85 % of java submissions
Your memory usage beats 63.94 % of java submissions (46.1 MB)
*/

// @lc code=start
class MyCircularQueue {
    int[] q;
    int s, e;

    public MyCircularQueue(int k) {
        q = new int[k];
        s = 0;
        e = -1;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        e = (e + 1) % q.length;
        q[e] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (s == e) {
            s = 0;
            e = -1;
        } else {
            s = (s + 1) % q.length;
        }
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : q[s];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : q[e];
    }
    
    public boolean isEmpty() {
        return e == -1;
    }
    
    public boolean isFull() {
        return !isEmpty() && ((e == s - 1) || (s == 0 && e == q.length - 1));
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

