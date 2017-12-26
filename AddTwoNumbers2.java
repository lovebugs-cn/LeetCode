package leetcode;

import java.util.Stack;

public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){

        if (l1 == null || l2 == null)
            return null;

        Stack<Integer> sta1 = new Stack<Integer>();
        Stack<Integer> sta2 = new Stack<Integer>();
        Stack<Integer> sta3 = new Stack<Integer>();

        while (l1 != null){
            sta1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            sta2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!sta1.isEmpty() && !sta2.isEmpty()){
            int sum = sta1.pop() + sta2.pop() + carry;
            carry = sum / 10;
            sta3.push(sum % 10);
        }

        while (!sta1.isEmpty()){
            int sum = sta1.pop() + carry;
            carry = sum / 10;
            sta3.push(sum % 10);
        }
        while (!sta2.isEmpty()){
            int sum = sta2.pop() + carry;
            carry = sum / 10;
            sta3.push(sum % 10);
        }

        if (carry != 0){
            sta3.push(carry);
        }

        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        while (!sta3.isEmpty()){
            dummy.next = new ListNode(sta3.pop());
            dummy = dummy.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = ReverseList.createLinkedList(nums1);
        ListNode l2 = ReverseList.createLinkedList(nums2);
        ReverseList.printLinkedList(l1);
        ReverseList.printLinkedList(l2);

        ListNode head = addTwoNumbers2(l1, l2);
        ReverseList.printLinkedList(head);
    }
}
