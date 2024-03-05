/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

/*
39/39 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 63.47 % of java submissions (40.8 MB)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 || denominator < 0) && (numerator > 0 || denominator > 0)) {
            sb.append('-');
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append('.');

        Map<Long, Integer> prevR = new HashMap<>();
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den; 

            if (prevR.containsKey(num)) {
                int idx = prevR.get(num);
                sb.insert(idx, '(');
                sb.append(')');
                break;
            } else {
                prevR.put(num, sb.length());
            }
        }

        return sb.toString();
    }
}
// @lc code=end
