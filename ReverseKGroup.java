package leetcode;

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k){

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        int len = 0;
        while (head != null){
            head = head.next;
            len ++;
        }

        for (int i = 0; i < len - k + 1; i += k){
            ListNode cur = pre.next;
            ListNode next = cur.next;
            for (int j = 0; j < k - 1; j ++){
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = reverseKGroup(head, k);
        ReverseList.printLinkedList(newHead);
    }
}
