/*
 * @lc app=leetcode id=950 lang=java
 *
 * [950] Reveal Cards In Increasing Order
 */

/*
33/33 cases passed (3 ms)
Your runtime beats 97.57 % of java submissions
Your memory usage beats 76.46 % of java submissions (43.3 MB)
 */

// @lc code=start
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] answer = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        for (int j = 0; j < n; j += 2, i++) {
            answer[j] = deck[i];
            if (j != n - 1) queue.add(j + 1);
        }

        if (answer[n - 1] != 0 && !queue.isEmpty()) queue.offer(queue.poll()); 
        while (!queue.isEmpty()) {
            answer[queue.poll()] = deck[i++];
            if (!queue.isEmpty()) queue.offer(queue.poll());
        }
        return answer;
    }
}
// @lc code=end

