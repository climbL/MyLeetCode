public class _852_剑指OfferII_069_山峰数组的顶部 {

    // 时间复杂度O(n)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (arr[left] < (left + 1 < arr.length ? arr[left + 1] : Integer.MIN_VALUE)) {
                left++;
            }
            return left;
        }
    }

    // 二分法: 时间复杂度O(logn)
    class Solution_1 {
        public int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            int l = 1, r = n-2, m, ans = 0;
            while(l<=r){
                m = (l+r)/2;
                if(arr[m]>arr[m+1]){
                    ans = m;
                    r = m-1;
                }
                else{
                    l = m+1;
                }
            }
            return ans;
        }
    }


}
