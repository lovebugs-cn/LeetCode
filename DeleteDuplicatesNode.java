package leetcode;

public class DeleteDuplicatesNode {

    public static ListNode deleteDuplicates(ListNode head){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){
            while (cur.next != null && cur.next.val == cur.val)
                cur = cur.next;
            if (pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5};
        int[] nums2 = {1, 1, 1, 2, 3};
        ListNode head1 = ReverseList.createLinkedList(nums1);
        ListNode head2 = ReverseList.createLinkedList(nums2);
        ReverseList.printLinkedList(head1);
        ListNode newHead1 = deleteDuplicates(head1);
        ReverseList.printLinkedList(newHead1);
        ReverseList.printLinkedList(head2);
        ListNode newHead2 = deleteDuplicates(head2);
        ReverseList.printLinkedList(newHead2);
    }
}
