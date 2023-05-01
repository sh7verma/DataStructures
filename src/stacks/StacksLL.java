package stacks;

public class StacksLL {
    private static class StackNode {
        private int value;
        private StackNode next;

        public StackNode(int value, StackNode next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackNode head = null;
    private int size = 0;

    public int peek() {
        return head.value;
    }

    public void push(int element) {
        head = new StackNode(element, head);
        size++;
    }

    public int pop() {
        isEmpty();
        int value = head.value;
        head = head.next;
        size--;

        return value;
    }

    public void insertAtBottom(int element) {
        if (head == null) {
            push(element);
        } else {
            int temp = pop();
            insertAtBottom(element);
            push(temp);
        }
    }

    public void sortedInsert(int element) {
        if (head ==null || element >= peek()) {
            push(element);
        } else {
            int temp = pop();
            sortedInsert(element);
            push(temp);
        }
    }

    public void print() {
        isEmpty();
        StackNode curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    private void isEmpty() {
        if (head == null) {
            throw new IllegalStateException("empty");
        }
    }


}
