package leetcode;

public class ReorderList {

    public static void reorderList(ListNode head){

        if (head == null || head.next == null)
            return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while ( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode fastHead = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode cur = fastHead;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode head1 = dummy.next;
        ListNode head2 = pre;

        while (head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        reorderList(head);
        ReverseList.printLinkedList(head);
    }
}
