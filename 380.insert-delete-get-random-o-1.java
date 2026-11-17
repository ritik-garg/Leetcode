/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

/*
21/21 cases passed (26 ms)
Your runtime beats 79.24 % of java submissions
Your memory usage beats 48.06 % of java submissions (100.2 MB)
*/

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    List<Integer> l;
    Map<Integer, Integer> m;
    Random r;

    public RandomizedSet() {
        l = new ArrayList<>();
        m = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        l.add(val);
        m.put(val, l.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;
        
        int i = m.get(val);
        l.set(i, l.getLast());
        m.put(l.get(i), i);
        m.remove(val);
        l.removeLast();
        return true;
    }
    
    public int getRandom() {
        return  l.get(r.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

