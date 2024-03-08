class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0, count = 0;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
                count = 1;
            } else if (freq[num] == max) {
                count++;
            }
        }
        return count * max;
    }
}