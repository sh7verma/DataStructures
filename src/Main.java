import linkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertTail(0);
        singleLinkedList.insertTail(1);
        singleLinkedList.insertTail(2);
//        singleLinkedList.insertTail(4);
//        singleLinkedList.insertTail(5);
        singleLinkedList.display();
        singleLinkedList.reverseTillK(4);

//        singleLinkedList.findMid();
//        singleLinkedList.reorderList();
//        System.out.println("Final Result");
        singleLinkedList.display();
    }
}