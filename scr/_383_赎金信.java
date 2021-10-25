import java.util.HashMap;
import java.util.Map;

public class _383_赎金信 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character,Integer> map = new HashMap<>();
            int m_len = magazine.length();
            for (int i = 0; i < m_len; i++) {
                int count = map.getOrDefault(magazine.charAt(i),0);
                map.put(magazine.charAt(i),count+1);
            }
            int r_len = ransomNote.length();
            for (int i = 0; i < r_len; i++) {
                int count = map.getOrDefault(ransomNote.charAt(i),0);
                if (count==0){
                    return false;
                }
                map.put(ransomNote.charAt(i),count-1);
            }
            return true;
        }
    }

    /**
     * 也可以用indexOf()查找第一个符合条件的字符，然后标记该字符已使用；找不到则返回false
     */





}
