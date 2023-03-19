package linkedList;

public class SingleLinkedList {
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
    }

    public void removeHead() {
        checkEmpty();
        Node curr = head;
        head = curr.next;
    }

    public void deleteNodes(int value) {
        checkEmpty();
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
        checkEmpty();
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
        checkEmpty();

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + "->");
            curr = curr.next;
        }
        System.out.println("END");
    }

    private void checkEmpty() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
    }

    public void reverseRecursive() {
        head = reverseRecursiveUtils(head, null);
    }

    public void removeDuplicates() {
        checkEmpty();
        Node curr = head;
        Node temp = null;
        while (curr != null && curr.next != null) {
            temp = curr;
            while (temp.next != null) {
                if (curr.value == temp.next.value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
    }

    public void removeDuplicates(int value) {
        checkEmpty();
        Node curr = head;
        Node temp = null;
        while (curr != null && curr.next != null) {
            temp = curr;
            while (temp.next != null) {
                if (temp.next.value == value) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            curr = curr.next;
        }
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

    public SingleLinkedList reverseCopy() {
        checkEmpty();
        SingleLinkedList list = new SingleLinkedList();
        Node curr = head;
        while (curr != null) {
            list.head = new Node(curr.value, list.head);
            curr = curr.next;
        }
        return list;
    }

    public SingleLinkedList copy() {
        checkEmpty();
        Node curr = head;

        SingleLinkedList list = new SingleLinkedList();
        list.head = new Node(head.value);
        Node newListCurr = list.head;

        while (curr.next != null) {
            newListCurr.next = new Node(curr.next.value);
            newListCurr = newListCurr.next;
            curr = curr.next;
        }
        return list;
    }

    public void reverseList() {
        checkEmpty();
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


    public boolean compareLists(SingleLinkedList list1, SingleLinkedList list2) {
        boolean result = compareLists(list1.head.next, list2.head.next);
        System.out.println(result);
        return result;
    }

    public boolean iterativeCompareLists(SingleLinkedList list1, SingleLinkedList list2) {
        boolean result = false;
        Node curr1 = list1.head;
        Node curr2 = list2.head;


        while (curr1 != null && curr2 != null) {

            if (curr1.value != curr2.value) {
                result = false;
                System.out.println(result);

                return result;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if (curr1 == null && curr2 == null) {
            result = true;
            System.out.println(result);

            return result;
        }

        System.out.println(result);
        return result;
    }

    public boolean compareLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null || (head1.value != head2.value)) {
            return false;
        } else {
            return compareLists(head1.next, head2.next);
        }
    }


    public int size() {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        System.out.println("size->" + size);
        return size;
    }

    public void nthNodeFromBeginning(int index) {
        int tempIndex = 0;
        Node curr = head;
        while (curr != null) {
            if (index == tempIndex) {
                System.out.println(curr.value);
                return;
            }
            tempIndex++;
            curr = curr.next;
        }
        System.out.println("Index out of Bound");
    }

    public void nthNodeFromTail(int index) {
        checkEmpty();
        int indexFromLast = size() - index;
        int tempIndex = 0;
        Node curr = head;
        while (curr != null) {
            if (indexFromLast == tempIndex) {
                System.out.println(curr.value);
                return;
            }
            tempIndex++;
            curr = curr.next;
        }
        System.out.println("Index out of Bound");
    }

}
