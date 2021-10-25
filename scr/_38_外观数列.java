public class _38_外观数列 {

    class Solution {
        public String countAndSay(int n) {
            String s = "1";
            char num='1';
            int count = 0;

            for (int i = 1; i <n ; i++) {
                StringBuilder stringBuilder = new StringBuilder("");
                for (int j = 0; j < s.length(); j++) {
                    num = s.charAt(j);
                    count++;
                    if(j==s.length()-1 || num!=s.charAt(j+1)){
                        stringBuilder.append(count).append(num);
                        count = 0;
                    }

                }
                s = stringBuilder.toString();
            }
            return s;
        }
    }

}
