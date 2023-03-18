import linkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.insertHead(10);
        singleLinkedList.insertHead(2);
        singleLinkedList.insertHead(5);
        singleLinkedList.insertHead(3);

        singleLinkedList.sortedInsert(1);
        singleLinkedList.sortedInsert(5);
        singleLinkedList.sortedInsert(4);
        singleLinkedList.insertTail(6);
        singleLinkedList.insertTail(5);
        singleLinkedList.sortedInsert(12);
//        singleLinkedList.removeHead();
        singleLinkedList.deleteFirstNodes(5);
        singleLinkedList.deleteList();
        singleLinkedList.display();

        singleLinkedList.search(1);


    }
}