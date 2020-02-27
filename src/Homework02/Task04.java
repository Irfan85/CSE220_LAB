package Homework02;

import Lab04.LinkedList;
import Lab04.Node;

import java.util.Arrays;

public class Task04 {
    public static void main(String[] args) {
        // Task 4.1
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        int[] c = zigzag(a, b);
        System.out.println(Arrays.toString(c));

        // Task 4.2
        int[] d = zigzag(a, 2, b, 3);
        System.out.println(Arrays.toString(d));

        // Task 4.3
        Object[] aO = {1, 2, 3, 4};
        Object[] bO = {5, 6, 7, 8};

        LinkedList aL = new LinkedList(aO);
        LinkedList bL = new LinkedList(bO);

        LinkedList cL = zigzag(aL, bL);
        cL.printList();
    }

    // For linear array
    public static int[] zigzag(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int idx = 0;

        for(int i = 0; i < a.length; i++){
            c[idx++] = a[i];
            c[idx++] = b[i];
        }

        return c;
    }

    // For circular array
    public static int[] zigzag(int[] a, int startA, int[] b, int startB){
        int[] c = new int[a.length + b.length];
        int idx = 0;

        int offsetA = startA;
        int offsetB = startB;

        for(int i = 0; i < a.length; i++){
            c[idx++] = a[offsetA % a.length];
            c[idx++] = b[offsetB % b.length];

            offsetA++;
            offsetB++;
        }

        return c;
    }

    // For linked list
    public static LinkedList zigzag(LinkedList a, LinkedList b){
        LinkedList c = new LinkedList(new Node(a.head.element, new Node(b.head.element, null)));
        int idx = 2;

        Node n2 = b.head.next;
        for(Node n1 = a.head.next; n1 != null; n1 = n1.next, n2 = n2.next){
            c.insert(n1.element, idx++);
            c.insert(n2.element, idx++);
        }

        return c;
    }
}
