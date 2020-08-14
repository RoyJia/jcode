package datastructure.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    public void test_checkBrackets_withStack() {
        String str = "<ab(<aa)22>";
        Stack<Character> leftBracketsStack = new Stack<Character>();

        str.chars().forEach(c -> {
            if (c == '<') {
                leftBracketsStack.push((char)c);
            } else if (c == '(') {
                leftBracketsStack.push((char)c);
            } else if (c == ')') {
                if (leftBracketsStack.pop() != '(') return;
            } else if (c == '>') {
                if (leftBracketsStack.pop() != '<') return;
            }
        });

        assertTrue(leftBracketsStack.empty());
    }

}