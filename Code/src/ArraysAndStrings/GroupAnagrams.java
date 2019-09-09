package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String key;
        char[] strCh;
        for (String str : strs) {
            strCh = str.toCharArray();
            Arrays.sort(strCh);
            key = String.valueOf(strCh);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
