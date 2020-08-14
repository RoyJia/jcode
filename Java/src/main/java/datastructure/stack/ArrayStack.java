package datastructure.stack;

public class ArrayStack {
    private final int DEFAULT_CAPACITY = 10;

    private int[] array;
    private int capacity;
    private int n;

    public ArrayStack() {
        this.n = 0;
        this.array = new int[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        this.n = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public void push(int i) {
        if (n < capacity) {
            array[n] = i;
            return;
        } else {
            capacity = 2 * capacity;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, array.length-1);
            array = newArray;
        }
        n++;
    }

    public int pop() {
        if (n == 0) {
            return 0;
        }

        n--;
        return array[n];
    }
}
