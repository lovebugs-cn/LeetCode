package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

public class ReverseList {

    public static ListNode reverseList (ListNode head){

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode createLinkedList(int[] arr){
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;

        }

        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(arr);
        printLinkedList(head);

        ListNode newHead = reverseList(head);
        printLinkedList(newHead);
    }
}
