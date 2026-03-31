package leetcode.day_01;

public class LC_002_addTwoNumbers {
    public static void main(String[] args) {

        // 测试用例 1: l1 = [2,4,3], l2 = [5,6,4]  (342 + 465 = 807)
        ListNode l1 = createLinkedList(new int[]{2, 4, 3, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = createLinkedList(new int[]{5, 6, 4});

        System.out.println("输入链表 1:");
        printLinkedList(l1);
        System.out.println("输入链表 2:");
        printLinkedList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("相加后的结果:");
        printLinkedList(result); // 预期输出: 7 -> 0 -> 8
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode newhead = new ListNode(0);
        ListNode cur = newhead;
        int cin = 0;
        //开始遍历两个链表的共同长度部分
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + cin;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cin=sum/10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //处理较长链表的非公共长度部分
        while (cur1 != null) {
            int sum = cin + cur1.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cin=sum/10;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int sum = cin + cur2.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cin=sum/10;
            cur2 = cur2.next;
        }
        if (cin == 1) {
            cur.next = new ListNode(cin);
        }

        return newhead.next;

    }

    // 3. 辅助方法：快速将数组转为链表
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 4. 辅助方法：打印链表
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}
