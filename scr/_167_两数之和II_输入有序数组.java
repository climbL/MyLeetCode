public class _167_两数之和II_输入有序数组 {

    /**
     * 二分法：时间复杂度为O(nlogn)
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int n = numbers.length;
            int[] ans = new int[2];

            for (int i = 0; i < n-1; i++) {
                int search_result = search(numbers,i+1,target-numbers[i]);
                if(search_result!=-1){
                    ans[0] = i;
                    ans[1] = search_result;
                }
            }
            return ans;
        }

        public int search(int[] numbers, int begin, int target){
            int l = begin;
            int r = numbers.length-1;
            int m;
            while (l<=r){
                m=(l+r)/2;
                if(numbers[m]==target){
                    return m;
                }
                if(numbers[m]<target){
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
            return -1;
        }
    }

    /**
     * 双指针法：左指针指向开头，右指针指向末尾，两指针之和小于target则左指针++，否则右指针--；
     *         时间复杂度O(n)
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l = 0;
            int r = numbers.length - 1;
            while (numbers[l] + numbers[r] != target) {
                if (numbers[l] + numbers[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return new int[]{l, r};
        }
    }





}
