public class _476_数字的补数 {


    class Solution {
        public int findComplement(int num) {
            int ans = Integer.MAX_VALUE;
            int l = 31-Integer.toBinaryString(num).length();
            while (l>0){
                ans = ans>>1;
                l--;
            }
            return ans^num;
        }
    }


}
