package common_check;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    List<Integer> values;

    public MinStack() {
        values = new ArrayList<Integer>();
    }

    public void push(int x) {
        values.add(x);
    }
    
    public void pop() {
        if (values.size() > 0)values.remove(values.size() - 1);
    }
    
    public int top() {
        if (values.size() == 0) {
            return 0;
        }
        
        return values.get(values.size() - 1);
    }
    
    public int getMin() {
        if (values.size() == 0) return 0;

        int minValue = values.get(0);

        for (int v : values) {
            if (minValue > v) {
                minValue = v;
            }
        }

        return minValue;
    }

}