import java.util.HashMap;
import java.util.Map;

public class _242_有效的字母异位词 {

    // 因为都是字母，可以把map换成长度为26的数组，索引为 charAt(i)-'a'
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            int s_len = s.length();
            int t_len = t.length();
            for (int i = 0; i < s_len; i++) {
                int count = map.getOrDefault(s.charAt(i), 0);
                map.put(s.charAt(i), count + 1);
            }
            for (int i = 0; i < t_len; i++) {
                int count = map.getOrDefault(t.charAt(i), 0);
                if (count == 0) {
                    return false;
                }
                count--;
                if (count == 0) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), count);

                }
            }
            return map.isEmpty();
        }
    }

    /**
     * 还可以排序，然后比较字符数组是否equal
     */


}
