package leetcode.day_01;

public class LC_876_middleNode {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7};
        ListNode head =new ListNode(arr[0]);
        ListNode cur;
        cur=head;
        for (int i = 1; i < arr.length; i++) {
            cur.next=new ListNode(arr[i] );
            cur=cur.next;
        }
        ListNode middleNode=middleNode2(head);
        while(middleNode!=null){
            System.out.print(middleNode.val+"->");
            middleNode=middleNode.next;
        }
    }

    public static ListNode middleNode2(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head){
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        int count=length/2;
        cur=head;
        for (int i = 0; i < count; i++) {
            cur=cur.next;
        }
        return cur;
    }
}
