/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

/*
78/78 cases passed (16 ms)
Your runtime beats 97.17 % of java submissions
Your memory usage beats 49.12 % of java submissions (54.5 MB)
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        
        int left = 0, right = people.length - 1;
        while(left < right) {
            if(people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        boats += left == right ? 1 : 0;
        return boats;
    }
}
// @lc code=end

