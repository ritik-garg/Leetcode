class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while(freq[ch - 'a']-- > 0) {
                answer.append(ch);
            }
        }

        for (int i = 0; i < 26; ++i) {
            while(freq[i]-- > 0) {
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }
}