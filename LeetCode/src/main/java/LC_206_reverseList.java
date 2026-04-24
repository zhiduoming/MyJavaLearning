public class LC_206_reverseList {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                //保存当前节点的下一个节点
                ListNode temp = cur.next;
                //将节点指向改变
                cur.next = pre;
                //更新 pre
                pre = cur;
                //更新 cur
                cur = temp;
            }
            return pre;
        }
    }
}
