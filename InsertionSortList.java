package leetcode;

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head){

        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            pre = dummy;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,6,7,1,2};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = insertionSortList(head);
        ReverseList.printLinkedList(newHead);
    }
}
