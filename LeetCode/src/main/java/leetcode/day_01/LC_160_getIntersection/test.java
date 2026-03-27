package leetcode.day_01.LC_160_getIntersection;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        // 1. 创建相交的公共部分： [8, 4, 5]
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // 2. 创建链表 A 的独有部分： [4, 1] -> 然后连接公共部分
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common; // 连接！

        // 3. 创建链表 B 的独有部分： [5, 0, 1] -> 然后连接公共部分
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common; // 连接到同一个 common 对象

        // 4. 执行测试
        ListNode result = getIntersectionNode2(headA, headB);

        // 5. 打印结果
        if (result != null) {
            System.out.println("相交节点的数值是: " + result.val);
            System.out.println("内存地址是否一致: " + (result == common));
        } else {
            System.out.println("两个链表不相交");
        }
    }

    public static ListNode getIntersectionNode(ListNode headA ,ListNode headB){
        HashSet<ListNode> set =new HashSet<>();
        ListNode curA =headA;
        ListNode curB =headB;

        while(curA!=null){
            set.add(curA);
            curA=curA.next;
        }
        while(curB!=null){
            if(set.contains(curB)){
                return curB;
            }
            curB=curB.next;
        }
        return null;

    }
    public static ListNode getIntersectionNode2(ListNode headA ,ListNode headB){
        ListNode curA=headA ,curB=headB;
        while(curA!=curB){
            curA=curA==null? headB: curA.next;
            curB=curB==null? headA: curB.next;
        }
        return curA;
    }
}
