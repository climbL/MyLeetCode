public class _203_移除链表元素 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = head;
            ListNode prev = dummy;
            while (cur!=null){
                if(cur.val==val){
                    cur = cur.next;     // 先把下一个节点存下来
                    prev.next = cur;
                }
                else{
                    prev = cur;
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }









}
