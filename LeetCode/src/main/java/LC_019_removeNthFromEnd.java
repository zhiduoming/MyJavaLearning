public class LC_019_removeNthFromEnd {
    public static void main(String[] args) {

        int[] arr= {1,2,3,4,5,6,7};
        ListNode head =new ListNode(arr[0]);
        ListNode cur;
        cur=head;
        for (int i = 1; i < arr.length; i++) {
            cur.next=new ListNode(arr[i] );
            cur=cur.next;
        }
        ListNode newhead=removeNthFromEnd(head,7);
        while(newhead!=null){
            System.out.print(newhead.val+"->");
            newhead=newhead.next;
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head );
        ListNode fast=head,slow=dummy;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

        return dummy.next;
    }

}
