/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

/*
739/739 cases passed (2 ms)
Your runtime beats 62.94 % of java submissions
Your memory usage beats 59.14 % of java submissions (42.7 MB)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

public class Codec {
    Map<String, String> tinyUrls = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        tinyUrls.put(String.valueOf(longUrl.hashCode()), longUrl);
        return String.valueOf(longUrl.hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyUrls.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

