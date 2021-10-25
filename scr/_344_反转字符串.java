public class _344_反转字符串 {

    class Solution {
        public void reverseString(char[] s) {
            int begin = 0, end = s.length-1;
            char t;
            while(begin<end){
                t = s[begin];
                s[begin] = s[end];
                s[end] = t;
                begin++;
                end--;
            }
        }
    }




}
