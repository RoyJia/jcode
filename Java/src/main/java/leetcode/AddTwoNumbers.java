package leetcode;

/**
 * leetcode 2 Add two number with linked list
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        // 342 is stored as reverse order in linked list node
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode number1 = new ListNode(2, listNode2);

        // 465 is stored as reverse order in linked list node
        ListNode listNode21 = new ListNode(4);
        ListNode listNode22 = new ListNode(6, listNode21);
        ListNode number2 = new ListNode(5, listNode22);


        ListNode result = addTwoNumbers(number1, number2);
    }

    public static ListNode addTwoNumbers(ListNode number1, ListNode number2) {
        ListNode head = new ListNode(0);
        ListNode p1 = number1, p2 = number2, curr = head;

        int carry = 0;

        while (p1 != null || p2 != null) {
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;

            int sum = carry + val1 + val2;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
