package leetcode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if (l1 == null && l2 == null)
            return null;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0)
            cur.next = new ListNode(carry);

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = ReverseList.createLinkedList(nums1);
        ListNode l2 = ReverseList.createLinkedList(nums2);
        ReverseList.printLinkedList(l1);
        ReverseList.printLinkedList(l2);
        ListNode head = addTwoNumbers(l1,l2);
        ReverseList.printLinkedList(head);

    }


}
