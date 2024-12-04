/*
 * @lc app=leetcode id=1106 lang=java
 *
 * [1106] Parsing A Boolean Expression
 */

/*
78/78 cases passed (2 ms)
Your runtime beats 94.77 % of java submissions
Your memory usage beats 32.48 % of java submissions (44.5 MB)
 */

// @lc code=start
class Solution {
    int i = 0;

    public boolean parseBoolExpr(String expression) {
        return parse(expression.toCharArray());
    }

    private boolean parse(char[] e) {
        char ch = e[i];
        i++;
        if (ch == 't') return true;
        if (ch == 'f') return false;

        if (ch == '!') {
            i++;
            boolean not = !parse(e);
            i++;
            return not;
        }

        List<Boolean> childE = new ArrayList<>();
        i++;
        while (e[i] != ')') {
            if (e[i] != ',') childE.add(parse(e));
            else i++;
        }
        if (ch == '&') {
            boolean ans = true;
            for (Boolean b : childE) {
                ans &= b;
            }
            i++;
            return ans;
        } else {
            boolean ans = false;
            for (Boolean b : childE) {
                ans |= b;
            }
            i++;
            return ans;
        }
    }
}
// @lc code=end

