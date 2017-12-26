package leetcode;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head){

        if (head == null)
            return null;

        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null){
            if (cur.val == pre.val)
                pre.next = cur.next;
            else
                pre = cur;

            cur = cur.next;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4};
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        head = deleteDuplicates(head);
        ReverseList.printLinkedList(head);
    }
}
