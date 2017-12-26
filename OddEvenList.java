package leetcode;

public class OddEvenList {

    public static ListNode oddEvenList(ListNode head){

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = oddEvenList(head);
        ReverseList.printLinkedList(newHead);
    }
}
