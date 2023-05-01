package stacks;

public class StacksArray {

    private int[] data;
    private int capacity=1000;
    private int top = -1;

    public StacksArray() {
        data = new int[capacity];
    }

    public StacksArray(int size) {
        capacity = size;
        data = new int[capacity];

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void print() {
        for (int i = top; i > -1; i--) {
            System.out.println(data[i] + " ");
        }
    }

    public void push(int element) {
        checkOverflow();
        top++;
        data[top] = element;
    }

    private void checkOverflow() {
        if (size() == data.length) {
            throw new IllegalStateException("StackOverFlowException");
        }
    }

    public int pop() {
        checkEmpty();
        int temp = data[top];
        top--;
        return temp;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("StackEmptyException");
        }
    }

    public int top(){
        checkEmpty();
        return data[top];
    }


}
