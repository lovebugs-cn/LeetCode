package leetcode;

public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k){

        if (head == null || head.next == null)
            return head;

        int len = 0;
        ListNode newHead = head;
        while (newHead != null){
            len ++;
            newHead = newHead.next;
        }

        k = k % len;
        if (k == 0)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < k + 1; i ++)
            q = q.next;
        while (q != null){
            p = p.next;
            q = q.next;
        }
        ListNode node = p.next;
        ListNode res = node;
        p.next = null;
        for (int j = 0; j < k - 1; j ++)
            node = node.next;

        node.next = head;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = rotateRight(head, 3);
        ReverseList.printLinkedList(newHead);
    }
}
