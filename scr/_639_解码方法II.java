public class _639_解码方法II {

    // 题解：https://leetcode-cn.com/problems/decode-ways-ii/solution/gong-shui-san-xie-fen-qing-kuang-tao-lun-902h/
    // f[i]表示随后一个字符为s[i]时的解码个数
    class Solution {
        int mod = (int) 1e9 + 7;

        public int numDecodings(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            long[] f = new long[n];

            f[0] = cs[0] == '*' ? 9 : (cs[0] != '0' ? 1 : 0);
            for (int i = 1; i < n; i++) {
                if (cs[i] == '*') {
                    f[i] += (f[i - 1] * 9) % mod; // 单独作为一个item
                    // 与上个字符共同组成一个item
                    char pre = cs[i - 1];
                    if (pre == '1') {
                        f[i] += ((i - 2 >= 0 ? f[i - 2] : 1) * 9) % mod;
                    }
                    if (pre == '2') {
                        f[i] += ((i - 2 >= 0 ? f[i - 2] : 1) * 6) % mod;
                    }
                    if (pre == '*') {
                        f[i] += ((i - 2 >= 0 ? f[i - 2] : 1) * 15) % mod;
                    }
                } else {   // cs[i]为数字
                    char pre = cs[i - 1];
                    if (pre == '*') {   // 前一个字符为*
                        if (cs[i] == '0') {
                            f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 2 % mod;  // 此时只能和前一项组对儿
                        }
                        if (cs[i] >= '1' && cs[i] <= '9') {
                            f[i] += (f[i - 1]) % mod; // 单独作为一个item
                            if (cs[i] >= '1' && cs[i] <= '6') {
                                f[i] += ((i - 2 >= 0 ? f[i - 2] : 1) * 2) % mod;
                            }
                            if (cs[i] >= '7' && cs[i] <= '9') {
                                f[i] += ((i - 2 >= 0 ? f[i - 2] : 1)) % mod;
                            }
                        }
                    } else {    // 前一个字符为数字类型
                        if (cs[i] == '0') {
                            if (pre == '1' || pre == '2') {
                                f[i] += (i - 2 >= 0 ? f[i - 2] : 1) % mod;
                            }
                        }
                        if (cs[i] >= '1' && cs[i] <= '9') {
                            f[i] += (f[i - 1]) % mod; // 单独作为一个item
                            if (pre == '1') {
                                f[i] += (i - 2 >= 0 ? f[i - 2] : 1) % mod;
                            }
                            if (pre == '2' && cs[i] <= '6') {
                                f[i] += (i - 2 >= 0 ? f[i - 2] : 1) % mod;
                            }
                        }
                    }

                }
                f[i] = f[i] % mod;
            }
            return (int) f[n - 1];
        }
    }


}
