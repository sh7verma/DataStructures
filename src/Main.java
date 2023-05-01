import linkedList.SingleLinkedList;
import stacks.StacksArray;
import stacks.StacksLL;

public class Main {
    public static void main(String[] args) {

        StacksLL stack = new StacksLL();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.sortedInsert(3);
        stack.print();
    }
}