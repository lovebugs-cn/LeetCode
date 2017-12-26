package leetcode;

public class Partition {

    public static ListNode partition(ListNode head, int x){

        if (head == null || head.next == null)
            return head;

        ListNode lt = new ListNode(0);
        ListNode ltHead = lt;
        ListNode gt = new ListNode(0);
        ListNode gtHead = gt;

        while (head != null){
            if (head.val < x){
                lt.next = head;
                lt = lt.next;
            }else{
                gt.next = head;
                gt = gt.next;
            }
            head = head.next;
        }

        gt.next = null;
        lt.next = gtHead.next;

        return ltHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = partition(head,3);
        ReverseList.printLinkedList(newHead);
    }
}
