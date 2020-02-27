package Homework02;

import Lab04.LinkedList;
import Lab04.Node;

import java.util.Arrays;

public class Task06To16 {
    public static void main(String[] args) {
        // Task 05
        System.out.println("Task 05");
        Object[] a = {1, 2, 3};
        Object[] b = {4, 5, 6};

        LinkedList aL = new LinkedList(a);
        LinkedList bL = new LinkedList(b);

        Node product = product(aL.head, bL.head);
        new LinkedList(product).printList();

        // Task 06
        System.out.println("Task 06");
        Node sum = sum(aL.head, bL.head);
        new LinkedList(sum).printList();

        // Task 07
        System.out.println("Task 07");
        Node difference = difference(aL.head, bL.head);
        new LinkedList(difference).printList();

        // Task 08
        System.out.println("Task 08");
        int dotProduct = dotProduct(aL.head, bL.head);
        System.out.println(dotProduct);

        // Task 09
        System.out.println("Task 09");
        Node reversedConcatenation = rc(aL.head, bL.head);
        new LinkedList(reversedConcatenation).printList();

        // Task 10
        System.out.println("Task 10");
        int[] sorted = {1, 2, 3, 5, 6, 0};
        int[] sortedInsertion = sortedInsertion(sorted, 5, 4);
        System.out.println(Arrays.toString(sortedInsertion));

        // Task 11
        System.out.println("Task 11");
        int[] d = {1, 5, 3, 1, 6, 2, 5, 4, 4, 4, 5, 6, 2, 4};
        frequency(d);

        // Task 12
        System.out.println("Task 12");
        int secondMax = secondMax(d);
        System.out.println(secondMax);

        // Task 13
        System.out.println("Task 13");
        int[] e = {1, 2, 3, 4, 5};
        int median = median(e);
        System.out.println(median);

        // Task 14
        System.out.println("Task 14");
        Node eL = toList(e);
        new LinkedList(eL).printList();

        // Task 15
        System.out.println("Task 15");
        int[] eA = toArray(eL);
        System.out.println(Arrays.toString(eA));

        // Task 16
        System.out.println("Task 16");
        int[] m1 = {1, 4, 7, 8};
        int[] m2 = {2, 3, 9};
        int[] mergeSorted = mergeSorted(m1, m2);
        System.out.println(Arrays.toString(mergeSorted));
    }

    public static Node product(Node a, Node b) {
        int hElement = (int) a.element * (int) b.element;
        LinkedList cL = new LinkedList(new Node(hElement, null));
        int idx = 1;

        Node n2 = b.next;
        for (Node n1 = a.next; n1 != null; n1 = n1.next, n2 = n2.next) {
            int nElement = (int) n1.element * (int) n2.element;
            cL.insert(nElement, idx++);
        }

        return cL.head;
    }

    public static Node sum(Node a, Node b) {
        int hElement = (int) a.element + (int) b.element;
        LinkedList cL = new LinkedList(new Node(hElement, null));
        int idx = 1;

        Node n2 = b.next;
        for (Node n1 = a.next; n1 != null; n1 = n1.next, n2 = n2.next) {
            int nElement = (int) n1.element + (int) n2.element;
            cL.insert(nElement, idx++);
        }

        return cL.head;
    }

    public static Node difference(Node a, Node b) {
        int hElement = (int) a.element - (int) b.element;
        LinkedList cL = new LinkedList(new Node(hElement, null));
        int idx = 1;

        Node n2 = b.next;
        for (Node n1 = a.next; n1 != null; n1 = n1.next, n2 = n2.next) {
            int nElement = (int) n1.element - (int) n2.element;
            cL.insert(nElement, idx++);
        }

        return cL.head;
    }

    public static int dotProduct(Node a, Node b) {
        int dot = (int) a.element * (int) b.element;

        Node n2 = b.next;
        for (Node n1 = a.next; n1 != null; n1 = n1.next, n2 = n2.next) {
            dot += (int) n1.element * (int) n2.element;
        }

        return dot;
    }

    // Reverse concatenation
    public static Node rc(Node a, Node b) {
        LinkedList cL = new LinkedList(new Node(a.element, null));
        int idx = 1;

        for (Node n = a.next; n != null; n = n.next) {
            cL.insert(n.element, idx++);
        }

        for (Node n = b; n != null; n = n.next) {
            cL.insert(n.element, idx);
        }

        return cL.head;
    }

    public static int[] sortedInsertion(int[] a, int m, int n) {
        int[] c = a.clone();

        if (m < c.length) {
            int idx = 0;
            for (int i = 0; i < m; i++) {
                if (c[i + 1] > n) {
                    idx = i + 1;
                    break;
                }
            }

            int from = m - 1;
            int to = m;
            for (int i = 0; i < m - idx; i++) {
                c[to] = c[from];

                to = from;
                from--;
            }

            c[idx] = n;
        } else {
            System.err.println("No space left!");
        }

        return c;
    }

    public static void frequency(int[] a) {
        int[][] frequencyArray = new int[a.length][2];
        int rowIdx = 0;
        for (int i = 0; i < a.length; i++) {
            boolean ok = true;
            for (int j = 0; j < rowIdx; j++) {
                if (a[i] == frequencyArray[j][0]) {
                    frequencyArray[j][1] = frequencyArray[j][1] + 1;
                    ok = false;
                    break;
                }
            }

            if (ok) {
                frequencyArray[rowIdx++][0] = a[i];
                frequencyArray[rowIdx][1] = 1;
            }

        }

        for (int i = 0; i < rowIdx; i++) {
            System.out.println(frequencyArray[i][0] + " : " + frequencyArray[i][1]);
        }
    }

    public static int secondMax(int[] a) {
        int max = a[0];
        int secondMax = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                secondMax = max;
                max = a[i];
            }
        }

        return secondMax;
    }

    public static int median(int[] a) {
        int[] sortedA = Task03.sort(a);

        int mid = sortedA.length / 2;

        return sortedA[mid];
    }

    public static Node toList(int[] a) {
        Node head = new Node(a[0], null);
        Node node = head;

        for (int i = 1; i < a.length; i++) {
            Node newNode = new Node(a[i], null);
            node.next = newNode;
            node = newNode;
        }

        return head;
    }

    public static int[] toArray(Node a) {
        LinkedList aL = new LinkedList(a);
        int[] array = new int[aL.countNode()];
        int idx = 0;

        for (Node n = a; n != null; n = n.next) {
            array[idx++] = (int) n.element;
        }

        return array;
    }

    public static int[] mergeSorted(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                merged[k++] = a[i++];
            else
                merged[k++] = b[j++];
        }

        while (i < a.length)
            merged[k++] = a[i++];

        while (j < b.length)
            merged[k++] = b[j++];

        return merged;

    }

}
