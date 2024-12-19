/*
 * @lc app=leetcode id=1475 lang=java
 *
 * [1475] Final Prices With a Special Discount in a Shop
 */

/*
103/103 cases passed (1 ms)
Your runtime beats 98.94 % of java submissions
Your memory usage beats 83.57 % of java submissions (43.5 MB)
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] s = new int[prices.length];
        int top = 0;
        s[top++] = 0;
        for (int i = 1; i < prices.length; ++i) {
            while (top > 0 && prices[i] <= prices[s[top - 1]]) {
                prices[s[--top]] -= prices[i];
            }
            s[top++] = i;
        }
        return prices;
    }
}

/*
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < prices.length; ++i) {
            while (!s.isEmpty() && prices[i] <= prices[s.peek()]) {
                prices[s.pop()] -= prices[i];
            }
            s.push(i);
        }
        return prices;
    }
}
*/
// @lc code=end

