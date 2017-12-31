package leetcode;

public class SwapPairs {

    public static ListNode swapPairs(ListNode head){

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode reNode = dummy.next.next;
        while (dummy.next != null && dummy.next.next != null){
            ListNode node1 = dummy.next;
            ListNode node2 = dummy.next.next;
            ListNode next = node2.next;
            dummy.next = node2;
            node1.next = next;
            node2.next = node1;
            dummy = node1;
        }

        return reNode;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = swapPairs(head);
        ReverseList.printLinkedList(newHead);
    }
}
