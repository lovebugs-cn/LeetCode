package leetcode;

public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val){

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null){
            if (cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = cur.next.next;
                delNode.next = null;
            }else{
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        int val = 2;
        ListNode head = ReverseList.createLinkedList(nums);
        ReverseList.printLinkedList(head);
        ListNode newHead = removeElements(head, val);
        ReverseList.printLinkedList(newHead);
    }
}
