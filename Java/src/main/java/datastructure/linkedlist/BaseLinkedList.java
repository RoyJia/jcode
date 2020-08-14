package datastructure.linkedlist;


public class BaseLinkedList<T> {
    private static final Integer DEFAULT_CAPACITY = 10;
    private LNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public BaseLinkedList() {
        this.headNode = new LNode<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public BaseLinkedList(Integer capacity) {
        this.headNode = new LNode<>();
        this.length = 0;
        this.capacity = capacity;
    }

    public void add(T value) {
        // check item in linked list already
        LNode preNodeOfExistedNode = findPreNodeOfExistedNode(value);

        // if it's in linkedlist, then remove it and insert new at the begin
        if (preNodeOfExistedNode != null) {
            deleteWithPreNode(preNodeOfExistedNode);
            insertAtBegin(value);
        } else {
            if (length > capacity) {
                deleteEndNode();
            }
            insertAtBegin(value);
        }
    }

    void deleteEndNode() {
        LNode node = headNode;

        if (node == null) {
            return;
        }

        while (node.next != null) {
            node = node.next;
        }

        node = null;
        length--;
    }

    void deleteWithPreNode(LNode preNode) {
        LNode next = preNode.next;

        if (next != null) {
            if (next.next != null) {
                preNode.next = next.next;
            } else {
                preNode.next = null;
            }
            length--;
            next = null;
        }
    }

    void insertAtBegin(T value) {
        LNode node = new LNode(value, headNode);
        headNode = node;
        length++;
    }

    LNode findPreNodeOfExistedNode(T value) {
        LNode node = headNode;

        while(node.next != null) {
            if (value.equals(node.next.item)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void printAll() {
        LNode node = headNode;

        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
        System.out.println();
    }
}

class LNode<T> {
    T item;
    LNode<T> next;

    LNode(){}

    LNode(T item, LNode<T> next) {
        this.item = item;
        this.next = next;
    }
}