public class _876_链表的中间结点 {

    /**
     * 双指针：快慢指针
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode l1 = head;
            ListNode l2 = head;

            while (l2.next!=null){
                l1 = l1.next;
                l2 = l2.next;
                if(l2.next!=null){
                    l2 = l2.next;
                }
            }
            return l1;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
