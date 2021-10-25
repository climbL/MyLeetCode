import java.util.List;

public class _139_单词拆分 {

    /**
     * 动态规划：
     * f[i]表示[0,i-1]区间的字符是否可以匹配
     * 状态转移时，需要判断f[j]是否为true（即[0,j-1]是否可以匹配），且剩下的[j,i-1]的字符串是否在字典中
     * 状态转移方程：
     *      dp[i]=dp[j] && check(s[j..i−1])         check(s[j..i−1]) 表示子串 s[j..i-1]是否出现在字典中
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] f = new boolean[s.length() + 1];
            f[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    f[i] = f[j] && wordDict.contains(s.substring(j,i));
                    if(f[i]==true){
                        break;
                    }
                }
            }
            return f[s.length()];
        }

    }

}
