package leetcode;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n){

        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null){
            len ++;
            head = head.next;
        }
        ListNode node = dummy;
        for (int i = 0; i < len - n; i ++){
            node = node.next;
        }
        ListNode delNode = node.next;
        node.next = delNode.next;

        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n + 1; i ++)
            q = q.next;

        while (q != null){
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = removeNthFromEnd2(head, 2);
        ReverseList.printLinkedList(newHead);
    }
}
