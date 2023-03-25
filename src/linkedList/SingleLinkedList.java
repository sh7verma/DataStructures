package linkedList;

import org.w3c.dom.NodeList;

public class SingleLinkedList {
    private ListNode head;

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }
    }

    public void insertHead(int value) {
        head = new ListNode(value, head);
    }

    public void insertTail(int value) {
        ListNode newNode = new ListNode(value);
        ListNode curr = head;
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
        ListNode curr = head;
        head = curr.next;
    }

    public void deleteNodes(int value) {
        checkEmpty();
        if (head.value == value) {
            head = head.next;
        }


        ListNode curr = head;
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
        ListNode curr = head;
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
        ListNode curr = head;
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
        ListNode newNode = new ListNode(value);
        ListNode curr = head;
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

        ListNode curr = head;
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
        ListNode curr = head;
        ListNode temp = null;
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
        ListNode curr = head;
        ListNode temp = null;
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

    public ListNode reverseRecursiveUtils(ListNode currentNode, ListNode nextNode) {
        ListNode temp;
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
        ListNode curr = head;
        while (curr != null) {
            list.head = new ListNode(curr.value, list.head);
            curr = curr.next;
        }
        return list;
    }

    public SingleLinkedList copy() {
        checkEmpty();
        ListNode curr = head;

        SingleLinkedList list = new SingleLinkedList();
        list.head = new ListNode(head.value);
        ListNode newListCurr = list.head;

        while (curr.next != null) {
            newListCurr.next = new ListNode(curr.next.value);
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
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
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
        ListNode curr1 = list1.head;
        ListNode curr2 = list2.head;


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

    public boolean compareLists(ListNode head1, ListNode head2) {
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
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        System.out.println("size->" + size);
        return size;
    }

    public void nthNodeFromBeginning(int index) {
        int tempIndex = 0;
        ListNode curr = head;
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
        int indexFromLast = size() - (index + 1);
        int tempIndex = 0;
        ListNode curr = head;
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

    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int hasCircularCycle() {
        checkEmpty();
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            if (head == fast.next || head == fast.next.next) {
                System.out.println("Circular List");
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("List has circle");
                return 1;
            }
        }
        System.out.println("No circles found");
        return 0;
    }


    public ListNode loopPointDetectNode() {
        checkEmpty();
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = head;
        ListNode temp = null;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                temp = fast;
                break;
            }
        }
        while (curr.next != null && temp != null) {
            if (curr == temp) {
                return curr;
            }
            curr = curr.next;
            temp = temp.next;
        }
        System.out.println("No circles found");
        return null;
    }

    public ListNode removeloopPointDetectNode() {
        checkEmpty();
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = head;
        ListNode temp = null;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                temp = fast;
                break;
            }
        }
        while (curr.next != null && temp != null) {
            if (curr.next == temp.next) {
                temp.next = null;
                break;
            }
            curr = curr.next;
            temp = temp.next;
        }
        System.out.println("No circles found");
        return null;
    }

    public void findMid() {
        checkEmpty();
        ListNode slow = head;
        if (head.next == null) {
            System.out.println(slow.value);
            return;
        }
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
    }


    //1-2-3-4-5 k=2
//    5-4-1-2-3
//    0-1-2

    public void reverseTillK(int k) {
        if (head == null || k == 0)
            return;

        ListNode curr = head;

        int size = 0;

        while (curr != null) {
            size++;
            if (curr.next == null) {
                curr.next = head;
                break;
            }
            curr = curr.next;
        }

        k = k % size;
        int length = size - k;

        curr = head;
        int pointer = 0;
        ListNode tempHead = null;
        while (curr != null) {
            pointer++;
            if (pointer == length) {
                tempHead = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
        }

        head = tempHead;
    }


//    L0 → L1 → … → Ln - 1 → Ln
//    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

    public void reorderList() {
        if (head == null || head.next == null)
            return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }


}
