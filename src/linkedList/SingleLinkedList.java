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
        Node curr = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    public void removeHead() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        Node curr = head;
        head = curr.next;
    }

    public void deleteNodes(int value) {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        if (head.value == value) {
            head = head.next;
        }


        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.value == value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
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


        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.value == value) {
                curr.next = curr.next.next;
                return;
            } else {
                curr = curr.next;
            }
        }
    }

    public void search(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                System.out.println(value + "->Element Found");
                return;
            }
            curr = curr.next;
        }
        System.out.println(value + "->Element not Found");
    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value);
        Node curr = head;
        if (head == null || head.value > value) {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void display() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + "->");
            curr = curr.next;
        }
        System.out.println("END");
    }

    public void reverseRecursive() {
        head = reverseRecursiveUtils(head, null);
    }

    public Node reverseRecursiveUtils(Node currentNode, Node nextNode) {
        Node temp;
        if (currentNode == null) {
            return null;
        }
        if (currentNode.next == null) {
            currentNode.next = nextNode;
            return currentNode;
        }
        temp = reverseRecursiveUtils(currentNode.next, currentNode);
        currentNode.next = nextNode;
        return temp;
    }


    public void reverseList() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        if (head.next == null) {
            return;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


}
