public class LC_021_mergeTwoLists {
    public static void main(String[] args) {
        int[] arr1={1,2,4};
        int[] arr2={1,3,4};
        ListNode list1=new ListNode(arr1[0]);
        ListNode list2=new ListNode(arr2[0]);
        ListNode cur;
        cur=list1;
        for (int i = 1; i < arr1.length; i++) {
            cur.next=new ListNode(arr1[i]);
            cur=cur.next;
        }
        cur=list2;
        for (int i = 1; i < arr2.length; i++) {
            cur.next=new ListNode(arr2[i]);
            cur=cur.next;
        }



        ListNode newlist=mergeTwoLists(list1,list2);
        for(cur=newlist;cur!=null;cur=cur.next){
            System.out.print(cur.val+"->");
        }

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){

        ListNode prevhead=new ListNode(-1);
        ListNode prev=prevhead;

        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                prev.next=list1;
                list1=list1.next;
            }else {
                prev.next=list2;
                list2=list2.next;
            }
            prev=prev.next;
        }

        prev.next=list1==null? list2:list1;
        return prevhead.next;


    }


}
