package leetcode;

/**
 * leetcode 2 Add two number with linked list
 */
public class LC2AddTwoNumbers {

    public static void main(String[] args) {
        // 342 is stored as reverse order in linked list node
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode number1 = new ListNode(2, listNode2);

        // 465 is stored as reverse order in linked list node
        ListNode listNode21 = new ListNode(4);
        ListNode listNode22 = new ListNode(6, listNode21);
        ListNode number2 = new ListNode(5, listNode22);


        ListNode result1 = addTwoNumbers(number1, number2);
        ListNode result2 = add(number1, number2, 0);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), curr = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(carry % 10);
            curr = curr.next;
            carry = carry > 9 ? 1 : 0;
        }

        return head.next;
    }

    public static ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int x = l1 == null ? 0 : l1.val;
        int y = l2 == null ? 0 : l2.val;
        carry += x + y;

        ListNode n = new ListNode(carry % 10);
        n.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry > 9 ? 1 : 0);
        return n;
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
