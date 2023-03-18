package linkedList;

public class SingleLinkedList {
    private int size = 0;
    private Node head;

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertHead(int value) {
        head = new Node(value, head);
        size++;
    }

    public void insertTail(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
    }

    public void removeHead() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        Node temp = head;
        head = temp.next;
    }

    public void deleteNodes(int value) {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        if (head.value == value) {
            head = head.next;
        }


        Node temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.value == value) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    public void deleteList() {
        head = null;
    }

    public void deleteFirstNodes(int value) {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        if (head.value == value) {
            head = head.next;
        }


        Node temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.value == value) {
                temp.next = temp.next.next;
                return;
            } else {
                temp = temp.next;
            }
        }
    }

    public void search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                System.out.println(value + "->Element Found");
                return;
            }
            temp = temp.next;
        }
        System.out.println(value + "->Element not Found");
    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (head == null || head.value > value) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (temp.next != null && temp.next.value < value) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void display() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }


}
