import java.util.HashMap;

/**
 * @Title: 535. Encode and Decode TinyURL
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/4/13
 */
public class Codec {

    HashMap<String, String> longToShort = new HashMap<>();
    HashMap<String, String> shortToLong = new HashMap<>();
    String base = "http://tinyurl.com/";
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int LENGTH_OF_SHORT_URL = 6;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) return base + longToShort.get(longUrl);
        String value = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < LENGTH_OF_SHORT_URL; ++i) {
                sb.append(chars.charAt((int) Math.random() * chars.length()));
                value = sb.toString();
            }
        } while (shortToLong.containsKey(value));
        longToShort.put(longUrl, value);
        shortToLong.put(value, longUrl);
        return longToShort.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl.replace(base, ""));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
