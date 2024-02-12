/**
 * 169. Majority Element
 * Time: 99.82%
 * Memory: 62.69%
 */

class Solution {
    public int majorityElement(int[] nums) {
        // Moore Voting Algorithm
        int c = 1;
        int e = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(c == 0) e = nums[i];
            c += (e == nums[i]) ? 1 : -1;
        }
        return e;
    }
}