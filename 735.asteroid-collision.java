/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

/*
276/276 cases passed (6 ms)
Your runtime beats 23.43 % of java submissions
Your memory usage beats 79.55 % of java submissions (46.4 MB)
*/

// @lc code=start
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> r = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                r.push(i);
            } else {
                boolean addI = true;
                while (!r.empty()) {
                    int l = r.peek();
                    if (l < 0) {
                        addI = true;
                        break;
                    } else if (l == -i) {
                        r.pop();
                        addI = false;
                        break;
                    } else if (l < -i) {
                        addI = true;
                        r.pop();
                    } else {
                        addI = false;
                        break;
                    }
                }
                if (addI) r.push(i);
            }
        }   
        return r.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

