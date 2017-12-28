package leetcode;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            if (l1 == null){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
                continue;
            }
            if (l2 == null){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
                continue;
            }
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead = new ListNode(0);
        if (l1.val < l2.val){
            dummyHead.next = l1;
            dummyHead.next.next = mergeTwoLists2(l1.next, l2);
        }else{
            dummyHead.next = l2;
            dummyHead.next.next = mergeTwoLists2(l1, l2.next);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {-9, 3};
        int[] nums2 = {5, 7};
        ListNode l1 = ReverseList.createLinkedList(nums1);
        ListNode l2 = ReverseList.createLinkedList(nums2);
        ReverseList.printLinkedList(l1);
        ReverseList.printLinkedList(l2);
        ListNode merge = mergeTwoLists2(l1, l2);
        ReverseList.printLinkedList(merge);
    }
}
