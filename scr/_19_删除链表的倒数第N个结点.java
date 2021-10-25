import java.util.ArrayList;
import java.util.List;

public class _19_删除链表的倒数第N个结点 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 使用list存储每个节点地址。时间复杂度O(L),空间复杂度O(L)
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> list = new ArrayList<>();
            ListNode ans = head;
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int len = list.size();
            ListNode pre = len - n - 1 >= 0 ? list.get(len - n - 1) : null;
            if (pre == null) {
                return ans.next;
            }
            ListNode back = len - n + 1 < len ? list.get(len - n + 1) : null;
            pre.next = back;
            return ans;
        }
    }

    /**
     * 双指针：快慢指针,快的指针先走n步，快指针指向最后一个元素时，慢指针就指向倒数第n个元素
     * 技巧：可以使用哑结点（dummy node）来避免对头结点的讨论。初始化时快指针指向head，满指针指向dummy
     */

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first!=null){
                first = first.next;
                second = second.next;
            }
            second.next = second.next==null?null:second.next.next;
            return dummy.next;
        }
    }


}
