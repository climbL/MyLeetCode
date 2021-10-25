import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口: 窗口大小为s1.length(),使用c2统计每个字符对应窗口的字符数，统计时前一个字符的个数--，新加的字符的个数++
 */
public class _567_字符串的排列 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] c1 = new int[26];
            int[] c2 = new int[26];
            int n = s1.length();
            int m = s2.length();
            if(n>m){
                return false;
            }
            for (int i = 0; i < n; i++) {
                c1[s1.charAt(i) - 'a']++;
                c2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(c1, c2)) {
                return true;
            }
            for (int i = 1; i <= m-n; i++) {

                c2[s2.charAt(i - 1) - 'a']--;
                c2[s2.charAt(i+n-1) - 'a']++;
                if (Arrays.equals(c1, c2)) {
                    return true;
                }

            }
            return false;
        }
    }


}
