import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _282_给表达式添加运算符 {
    /**
     * 没有通过所有案例，不想写了...
     */
    class Solution {
        List<String> ans = new ArrayList<>();
        List<String> total = new ArrayList<>();

        public List<String> addOperators(String num, int target) {
            String s = String.valueOf(num);
            generate(s, "", 0);
            Long t = (long) target;
            for (String value : total) {
                if (compute(value).equals(t)) {
                    ans.add(value);
                }
            }
            return ans;
        }

        public void generate(String s, String now, int i) {
            now = now + s.charAt(i);
            if (i == s.length() - 1) {
                total.add(now);
                System.out.println(now);
//                return;
            } else {
                if(now.charAt(now.length()-1)!='0'){
                    generate(s,now,i+1);
                }
                generate(s, now + '+', i + 1);
                generate(s, now + '-', i + 1);
                generate(s, now + '*', i + 1);
            }

        }

        public Long compute(String s) {
            char fu = '%';
            Stack<Long> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder("");
                while(!(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*')){
                    stringBuilder.append(s.charAt(i));
                    i++;
                    if(i==s.length()){
                        break;
                    }
                }
                Long num = Long.parseLong(stringBuilder.toString());

                if (fu == '%' || fu == '+' || fu == '-') {
                    if(fu=='-'){
                        stack.push(-num);
                    }
                    else{
                        stack.push(num);
                    }
                } else {
                    long n = stack.pop();
                    n = n * num;
                    stack.push(n);
                }

                if (i < s.length()) {
                    fu = s.charAt(i);
                }
            }
            Long ans = 0L;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }

}
