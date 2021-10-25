public class _66_加一 {

    class Solution {
        public int[] plusOne(int[] digits) {
            digits[digits.length-1]++;
            int flg = 0;
            for (int i = digits.length-1; i >=0 ; i--) {
                digits[i] = digits[i] + flg;
                flg=0;
                if(digits[i]>=10){
                    digits[i]-=10;
                    flg=1;
                }
                else{
                    break;
                }
            }
            if(flg==1){
                int[] ans = new int[digits.length+1];
                ans[0]=1;   // 只有都为9才会出现这种情况，+1变成首位是1，其余是0
                return ans;
            }
            return digits;
        }
    }

}
