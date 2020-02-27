package Homework02;

import Lab04.LinkedList;
import Lab04.Node;

import java.util.Arrays;

public class Task01 {
    public static void main(String[] args) {
        // Task 1.1
        int[] a = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        int[] b = {2, 3, 4, 5, 2, 1, 10, 1, 2, 2, 4};

        int[] c = union(a, b);
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        // Task 1.2
        int[] d = union(a, 2, b, 3);
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));

        // Task 1.3
        Object[] aO = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        Object[] bO = {2, 3, 4, 5, 2, 1, 10, 1, 2, 2, 4};

        LinkedList aL = new LinkedList(aO);
        LinkedList bL = new LinkedList(bO);

        Node cL = union(aL.head, bL.head);
        new LinkedList(cL).printList();

    }

    // For linear array
    public static int[] union(int[] a, int[] b) {
        Object[] tempC = new Object[a.length + b.length];
        int tempCount = 0;

        for (int i = 0; i < a.length; i++) {
            if (isUnique(a[i], tempC, tempCount))
                tempC[tempCount++] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            if (isUnique(b[i], tempC, tempCount))
                tempC[tempCount++] = b[i];
        }

        int[] c = new int[tempCount];

        for (int i = 0; i < tempCount; i++) {
            c[i] = (int) tempC[i];
        }

        return c;
    }

    // For circular array
    public static int[] union(int[] a, int startA, int[] b, int startB) {
        Object[] tempC = new Object[a.length + b.length];
        int tempCount = 0;

        int offset = startA;

        for (int i = 0; i < a.length; i++) {
            if (isUnique(a[offset % a.length], tempC, tempCount))
                tempC[tempCount++] = a[offset % a.length];

            offset++;
        }

        offset = startB;

        for (int i = 0; i < b.length; i++) {
            if (isUnique(b[offset % b.length], tempC, tempCount))
                tempC[tempCount++] = b[offset % b.length];

            offset++;
        }

        int[] c = new int[tempCount];

        for (int i = 0; i < tempCount; i++) {
            c[i] = (int) tempC[i];
        }

        return c;
    }

    // For linked list
    public static Node union(Node a, Node b) {
        Node cHead = new Node(a.element, null);
        LinkedList c = new LinkedList(cHead);
        int idx = 0;

        for (Node n = a.next; n != null; n = n.next) {
            if (!c.contains(n.element))
                c.insert(n.element, idx++);
        }

        for (Node n = b; n != null; n = n.next) {
            if (!c.contains(n.element))
                c.insert(n.element, idx++);
        }

        return c.head;
    }

    public static boolean isUnique(int i, Object[] target, int targetSize) {
        boolean isNew = true;
        for (int j = 0; j < targetSize; j++) {
            if ((int) target[j] == i) {
                isNew = false;
                break;
            }
        }

        return isNew;
    }

}
