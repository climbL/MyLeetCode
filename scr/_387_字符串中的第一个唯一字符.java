import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _387_字符串中的第一个唯一字符 {

    class Solution {
        public int firstUniqChar(String s) {
            int len = s.length();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                if(!set.contains(s.charAt(i)) && s.substring(i+1).indexOf(s.charAt(i))==-1){
                    return i;
                }
                set.add(s.charAt(i));

            }
            return -1;
        }
    }



}
