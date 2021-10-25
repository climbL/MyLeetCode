public class _453_最小操作次数使数组元素相等 {

    /**
     * 每次操作既可以理解为使 n−1 个元素增加 1，也可以理解使 1 个元素减少 1
     */
    class Solution {
        public int minMoves(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
            }
            int ans = 0;
            for(int num : nums){
                ans+=(num-min);
            }
            return ans;
        }
    }

}
