import java.util.Arrays;

public class _557_反转字符串中的单词III {
    class Solution {
        public String reverseWords(String s) {
            char[] cs = s.toCharArray();
            int l = 0, r = 0;
            int n = cs.length;
            for (int i = 0; i < n; i++) {
                if (cs[i] == ' ' || i == n - 1) {
                    r = i != n - 1 ? i : n;
                    reverseString(cs, l, r);
                    l = i + 1;
                }

            }
            return String.valueOf(cs);
        }

        public void reverseString(char[] s, int l, int r) { // 翻转[l,r)区间的字符
            int begin = l, end = r - 1;
            char t;
            while (begin < end) {
                t = s[begin];
                s[begin] = s[end];
                s[end] = t;
                begin++;
                end--;
            }
        }
    }


}
