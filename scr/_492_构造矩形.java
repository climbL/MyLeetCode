public class _492_构造矩形 {

    class Solution {
        public int[] constructRectangle(int area) {
            int n = (int)Math.sqrt((double)area );
            if(n*n==area){
                return new int[]{n,n};
            }
            int[] ans = new int[2];
            for (int i = n; i >= 1; i--) {
                if(area%i==0){
                    ans[0] = area/i;
                    ans[1] = i;
                    break;
                }
            }
            return ans;
        }
    }


}
