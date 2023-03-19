import linkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList copy = new SingleLinkedList();
        singleLinkedList.insertHead(10);
        singleLinkedList.insertHead(2);
        singleLinkedList.insertHead(5);
        singleLinkedList.insertHead(5);

        singleLinkedList.sortedInsert(5);
        singleLinkedList.sortedInsert(2);
        singleLinkedList.sortedInsert(1);
        singleLinkedList.sortedInsert(5);
        singleLinkedList.sortedInsert(5);
        singleLinkedList.insertTail(6);
        singleLinkedList.insertTail(5);
        singleLinkedList.sortedInsert(452);
        singleLinkedList.display();

        copy = singleLinkedList.copy();
//        copy.deleteList();
        copy.display();
//        copy.insertHead(2);

        copy.size();

        copy.nthNodeFromBeginning(12);

    }
}