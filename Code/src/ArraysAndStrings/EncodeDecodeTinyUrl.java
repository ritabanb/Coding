package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyUrl {
    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        String shortUrl = Integer.toHexString(hashCode);
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
