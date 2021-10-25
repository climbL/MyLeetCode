import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _229_求众数II {

    /**
     * Hash统计，时间复杂度O(n)，空间复杂度O(n)
     */
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                int count = map.getOrDefault(num,0);
                count++;
                map.put(num,count);
            }
            List<Integer> ans = new ArrayList<>();
            int n = nums.length/3;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue()>n){
                    ans.add(entry.getKey());
                }
            }
            return ans;
        }
    }

    /**
     * 摩尔投票法:时间复杂度O(n)，空间复杂度O(1)
     * 题解：https://leetcode-cn.com/problems/majority-element-ii/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ws0rj/
     */
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int n1=0,n2=0;
            int c1=0,c2=0;
            for(int num:nums){
                if(num==n1) c1++;
                else if(num==n2) c2++;
                else {
                    if(c1==0){
                        n1=num;
                        c1++;
                    }
                    else if(c2==0){
                        n2 = num;
                        c2++;
                    }
                    else{
                        c1--;
                        c2--;
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            c1=0;
            c2=0;
            for(int num:nums){
                if(num==n1){
                    c1++;
                }
                else if(num==n2){
                    c2++;
                }
            }
            if(c1> nums.length/3){
                ans.add(n1);
            }
            if(c2> nums.length/3){
                ans.add(n2);
            }
            return ans;
        }
    }

}
