package Homework02;

import Lab04.LinkedList;
import Lab04.Node;

import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        // Task 2.1
        int[] a = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        int[] b = {2, 3, 4, 5, 2, 1, 10, 1, 2, 2, 4};

        int[] c = intersection(a, b);
        //Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        // Task 2.2
        int[] d = intersection(a, 2, b, 3);
        //Arrays.sort(d);
        System.out.println(Arrays.toString(d));

        // Task 2.3
        Object[] aO = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        Object[] bO = {2, 3, 4, 5, 2, 1, 10, 1, 2, 2, 4};

        LinkedList aL = new LinkedList(aO);
        LinkedList bL = new LinkedList(bO);

        Node cL = intersection(aL.head, bL.head);
        new LinkedList(cL).printList();
    }

    // For linear Array
    public static int[] intersection(int[] a, int[] b) {
        int[] minArray = a;
        int[] maxArray = b;

        if (b.length < a.length) {
            minArray = b;
            maxArray = a;
        }

        Object[] tempC = new Object[minArray.length];
        int idx = 0;
        for (int i = 0; i < minArray.length; i++) {
            if (isPresent(minArray[i], maxArray) && !isPresent(minArray[i], tempC)) {
                tempC[idx++] = minArray[i];
            }
        }

        int[] c = new int[idx];

        for (int i = 0; i < c.length; i++) {
            c[i] = (int) tempC[i];
        }

        return c;
    }

    // For circular array
    public static int[] intersection(int[] a, int startA, int[] b, int startB) {
        int[] minArray = a;
        int[] maxArray = b;

        int offset = startA;

        if (b.length < a.length) {
            minArray = b;
            maxArray = a;
            offset = startB;
        }

        Object[] tempC = new Object[minArray.length];
        int idx = 0;

        for (int i = 0; i < minArray.length; i++) {
            if (isPresent(minArray[offset % minArray.length], maxArray) && !isPresent(minArray[offset % minArray.length], tempC)) {
                tempC[idx++] = minArray[offset % minArray.length];
            }

            offset++;
        }

        int[] c = new int[idx];

        for (int i = 0; i < c.length; i++) {
            c[i] = (int) tempC[i];
        }

        return c;
    }

    // For linked list
    public static Node intersection(Node a, Node b) {
        LinkedList aL = new LinkedList(a);
        LinkedList bL = new LinkedList(b);

        LinkedList cL = null;
        int idx = 0;

        for (Node n = aL.head; n != null; n = n.next) {
            if (bL.contains(n.element)) {
                if (cL == null) {
                    cL = new LinkedList(new Node(n.element, null));

                    idx++;
                } else if (!cL.contains(n.element)) {
                    cL.insert(n.element, idx);

                    idx++;
                }
            }
        }

        return cL.head;
    }

    public static boolean isPresent(Object a, Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a)
                return true;
        }

        return false;
    }

    public static boolean isPresent(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a)
                return true;
        }

        return false;
    }

}
