package leetcode;

public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n){

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i ++)
            pre = pre.next;

        ListNode cur = pre.next;
        ListNode next = cur.next;

        for (int i = 0; i < n - m; i ++){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = reverseBetween(head,2,4);
        ReverseList.printLinkedList(newHead);
    }
}
