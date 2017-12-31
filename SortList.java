package leetcode;

public class SortList {

    public static ListNode sortList(ListNode head){
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        ListNode rHead = s.next;
        s.next = null;
        ListNode lHead = head;
        ListNode lhalf = mergeSort(lHead);
        ListNode rhalf = mergeSort(rHead);
        return merge(lhalf, rhalf);
    }

    private static ListNode merge(ListNode lHead, ListNode rHead) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (lHead != null && rHead != null){
            if (lHead.val < rHead.val){
                newHead.next = lHead;
                lHead = lHead.next;
            }else {
                newHead.next = rHead;
                rHead = rHead.next;
            }
            newHead = newHead.next;
        }
        if (lHead != null)
            newHead.next = lHead;
        if (rHead != null)
            newHead.next = rHead;

        ListNode res = dummy.next;
        dummy.next = null;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = sortList(head);
        ReverseList.printLinkedList(newHead);
    }
}
