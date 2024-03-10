import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] freq = new boolean[1001];
        for (int num : nums1) {
            freq[num] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int num : nums2) {
            if (freq[num]) {
                answer.add(num);
                freq[num] = false;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}