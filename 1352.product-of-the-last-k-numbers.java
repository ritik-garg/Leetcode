/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

/*
35/35 cases passed (16 ms)
Your runtime beats 99.65 % of java submissions
Your memory usage beats 49.31 % of java submissions (84.4 MB)
*/

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> p;

    public ProductOfNumbers() {
        p = new ArrayList<>();    
    }
    
    public void add(int num) {
        if (num == 0) {
            p.clear();
        } else {
            int pr = p.size() > 0 ? p.getLast() : 1;
            p.add(num * pr);
        }
    }
    
    public int getProduct(int k) {
        if (k > p.size()) return 0;
        if (k == p.size()) return p.getLast();
        return p.getLast() / p.get(p.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

