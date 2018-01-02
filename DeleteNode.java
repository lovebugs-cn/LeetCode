package leetcode;

public class DeleteNode {

    public static void deleteNode(ListNode node){

        if (node.next == null){
            node = null;
            return;
        }
        if (node == null)
            return;

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }

}
