/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

/*
 * 259/259 cases passed (5 ms)
 * Your runtime beats 51.68 % of java submissions
 * Your memory usage beats 83.32 % of java submissions (43 MB)
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        for (String dir : directories) { 
            if (dir.equals(".") || dir.isEmpty()) { 
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) { 
                    stack.pop();
                }
            } else { 
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }
}
// @lc code=end


/*
Solution with Split, 
259/259 cases passed (9 ms)
Your runtime beats 20.11 % of java submissions
Your memory usage beats 14.17 % of java submissions (44.7 MB)

class Solution {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> folders = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for(int i = 0; i < strings.length; ++i) {
            if (strings[i].equals("..") && !folders.isEmpty()) {
                folders.pop();
            } else if (!skip.contains(strings[i])) {
                folders.add(strings[i]);
            }
        }

        String answer = "";
        while (!folders.isEmpty()) {
            answer = "/" + folders.pop() + answer;
        }
        return answer.equals("") ? "/" : answer;
    }
}
 */