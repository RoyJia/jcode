package linkedlist;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class BaseLinkedListTest {

    BaseLinkedList<Integer> linkedList;

    @Test
    void test_BaseLinkedList() {
        linkedList = new BaseLinkedList<>();

        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
    }

    @Test
    public void test_JavaLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
    }
}