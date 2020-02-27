package Homework02;

import Lab04.LinkedList;
import Lab04.Node;

import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        // Task 3.1
        int[] a = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        int[] c = sort(a);
        System.out.println(Arrays.toString(c));

        // Task 3.2
        int[] d = sort(a, 4);
        System.out.println(Arrays.toString(d));

        // Task 3.3
        Object[] aO = {1, 2, 2, 2, 8, 1, 5, 10, 2, 5, 7, 1, 1, 1, 3};
        LinkedList aL = new LinkedList(aO);
        Node cL = sort(aL.head);
        new LinkedList(cL).printList();
    }

    // For linear array
    public static int[] sort(int[] a) {
        int[] sorted = a.clone();

        for (int i = 0; i < sorted.length; i++) {
            int swapCount = 0;

            for (int j = 1; j < sorted.length; j++) {
                if (sorted[j - 1] > sorted[j]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j - 1];
                    sorted[j - 1] = temp;

                    swapCount++;
                }
            }

            if (swapCount == 0)
                break;
        }

        return sorted;
    }

    // For circular array
    public static int[] sort(int[] a, int start) {
        // TO DO
        int[] sorted = a.clone();

        for (int i = 0; i < sorted.length; i++) {
            int preOffset = start;
            int offset = start + 1;
            int swapCount = 0;

            for (int j = 1; j < sorted.length; j++) {
                if (sorted[preOffset % sorted.length] > sorted[offset % sorted.length]) {
                    int temp = sorted[preOffset % sorted.length];
                    sorted[preOffset % sorted.length] = sorted[offset % sorted.length];
                    sorted[offset % sorted.length] = temp;

                    swapCount++;
                }

                preOffset++;
                offset++;
            }

            if (swapCount == 0)
                break;
        }

        return sorted;
    }

    // For linked list
    public static Node sort(Node a) {
        LinkedList sorted = new LinkedList(a);

        for (Node n = sorted.head; n != null; n = n.next) {
            int swapCount = 0;

            Node n1 = sorted.head;
            for (Node o = sorted.head.next; o != null; o = o.next) {
                if (((Integer) n1.element).compareTo((Integer) o.element) > 0) {
                    Object temp = n1.element;
                    n1.element = o.element;
                    o.element = temp;

                    swapCount++;
                }

                n1 = n1.next;
            }

            if (swapCount == 0)
                break;
        }

        return sorted.head;
    }
}
