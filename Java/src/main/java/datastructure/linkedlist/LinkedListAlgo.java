package datastructure.linkedlist;

public class LinkedListAlgo {

    public LNode reverseSingaleLinkedList(LNode head) {
        LNode pre = null;
        LNode curr = head;
        while (curr != null) {
            LNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public LNode findMiddleNode(LNode head) {
        if (head == null) {
            return null;
        }

        LNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
