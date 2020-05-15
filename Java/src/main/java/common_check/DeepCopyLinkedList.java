package common_check;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {
    static Map<Node, Node> touchedNodeMap = new HashMap<>();

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node deepCopied = copyNode(head);

        if (deepCopied == head) System.out.println("same reference");
    }

    static Node copyNode(Node node) {
        if (node == null) return null;

        if (touchedNodeMap.containsKey(node)) return touchedNodeMap.get(node);

        Node newNode = new Node(node.val);
        touchedNodeMap.put(node, newNode);

        newNode.next = copyNode(node.next);
        newNode.random = copyNode(node.random);
        
        return newNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}