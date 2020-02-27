package Lab02;

public class CircularArray {

    private int start;
    private int size;
    private Object[] cir;

    /*
     * if Object [] lin = {10, 20, 30, 40, null} then, CircularArray(lin, 2, 4) will
     * generate Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object[] lin, int st, int sz) {
        // TO DO
        this.start = st;
        this.size = sz;
        this.cir = new Object[lin.length];

        for (int i = 0, j = start; i < size; i++) {
            cir[j % cir.length] = lin[i];
            j++;
        }
    }

    // Prints from index --> 0 to cir.length-1
    public void printFullLinear() {
        // TO DO
        for (int i = 0; i < cir.length; i++) {
            if (i == 0)
                System.out.print(cir[i]);
            else
                System.out.print(", " + cir[i]);
        }

        System.out.println(".");
    }

    // Starts Printing from index start. Prints a total of size elements
    public void printForward() {
        // To DO
        for (int i = 0, j = start; i < size; i++) {
            if (j == start)
                System.out.print(cir[j % cir.length]);
            else
                System.out.print(", " + cir[j % cir.length]);

            j++;
        }

        System.out.println(".");
    }

    public void printBackward() {
        // TO DO
        for (int i = 0, j = start + size - 1; i < size; i++) {
            if (j == start + size - 1)
                System.out.print(cir[j % cir.length]);
            else
                System.out.print(", " + cir[j % cir.length]);

            j--;
            if (j == -1)
                j = cir.length - 1;
        }

        System.out.println(".");
    }

    // With no null cells
    public void linearize() {
        // TO DO
        Object[] lin = new Object[size];

        for (int i = 0, j = start; i < size; i++) {
            lin[i] = cir[j % cir.length];
            j++;
        }

        cir = lin;
    }

    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity) {
        // TO DO
        Object[] newCir = new Object[newcapacity];

        for (int i = 0, j = start; i < size; i++) {
            newCir[j % newCir.length] = cir[j % cir.length];
            j++;
        }

        cir = newCir;
    }

    // Start index becomes zero
    public void resizeByLinearize(int newcapacity) {
        // TO DO
        linearize();

        Object[] lin = new Object[newcapacity];

        for (int i = 0; i < cir.length; i++) {
            lin[i] = cir[i];
        }

        cir = lin;
    }

    /*
     * pos --> position relative to start. Valid range of pos--> 0 to size. Increase
     * array length by 3 if size==cir.length use resizeStartUnchanged() for
     * resizing.
     */
    public void insertByRightShift(Object elem, int pos) {
        // TO DO
        if (pos >= 0 && pos <= size) {
            if (size == cir.length)
                resizeStartUnchanged(cir.length + 3);

            int nShifts = size - pos;
            int from = (start + size - 1) % cir.length;
            int to = (from + 1) % cir.length;

            for (int i = 0; i < nShifts; i++) {
                cir[to] = cir[from];
                to = from;

                from--;
                if (from == -1)
                    from = cir.length - 1;
            }

            int offset = (start + pos) % cir.length;
            cir[offset] = elem;

            size++;
        }
    }

    public void insertByLeftShift(Object elem, int pos) {
        // TO DO
        if (pos >= 0 && pos <= size) {
            if (size == cir.length)
                resizeStartUnchanged(cir.length + 3);

            int nShifts = pos + 1;
            int from = start;
            int to = (start + cir.length - 1) % cir.length;

            for (int i = 0; i < nShifts; i++) {
                cir[to] = cir[from];
                to = from;

                from = (from + 1) % cir.length;
            }

            int offset = (start + pos) % cir.length;
            cir[offset] = elem;

            start--;
            if(start == -1)
                start = cir.length - 1;

            size++;
        }
    }

    /*
     * parameter--> pos. pos --> position relative to start. Valid range of pos--> 0
     * to size-1
     */
    public void removeByLeftShift(int pos) {
        // TO DO
        if (pos >= 0 && pos < size) {
            int nShifts = size - pos - 1;
            int from = (start + pos + 1) % cir.length;
            int to = (start + pos) % cir.length;

            for (int i = 0; i < nShifts; i++) {
                cir[to] = cir[from];

                to = from;
                from = (from + 1) % cir.length;
            }

            cir[to] = null;

            size--;
        }
    }

    /*
     * parameter--> pos. pos --> position relative to start. Valid range of pos--> 0
     * to size-1
     */
    public void removeByRightShift(int pos) {
        // TO DO
        if (pos >= 0 && pos < size) {
            int from = (start + pos - 1) % cir.length; // 50
            int to = (start + pos) % cir.length; // 40 (Offset)

            for (int i = 0; i < pos; i++) {
                cir[to] = cir[from];

                to = from;

                from--;
                if (from == -1)
                    from = cir.length - 1;
            }

            cir[to] = null;

            start = (start + 1) % cir.length;
            size--;
        }
    }

    // This method will check whether the array is palindrome or not
    public void palindromeCheck() {
        // TO DO
        boolean isPalindrome = true;

        int offset = start;
        int offsetPrime = start + size - 1;

        for (int i = 0; i < size / 2; i++) {
            if (cir[offset % cir.length] != cir[offsetPrime % cir.length]) {
                isPalindrome = false;
                break;
            } else {
                offset++;
                offsetPrime--;
                if (offsetPrime == -1)
                    offsetPrime = cir.length - 1;
            }
        }

        if (isPalindrome)
            System.out.println("This array is a palindrome.");
        else
            System.out.println("This array is NOT a palindrome.");
    }

    // This method will sort the values by keeping the start unchanged
    public void sort() {
        // TO DO
        for (int i = 0; i < size; i++) {
            int preOffset = start;
            int offset = start + 1;
            int swapCount = 0;

            for (int j = 0; j < size - 1; j++) {
                int val = cir[preOffset % cir.length].toString().compareTo(cir[offset % cir.length].toString());

                if (val > 0) {
                    Object temp = cir[preOffset % cir.length];
                    cir[preOffset % cir.length] = cir[offset % cir.length];
                    cir[offset % cir.length] = temp;

                    swapCount++;
                }

                preOffset++;
                offset++;
            }

            if (swapCount == 0)
                break;
        }
    }

    // This method will check the given array across the base array and if they are
    // equivalent interms of values return true, or else return false
    public boolean equivalent(CircularArray k) {
        // TO DO
        if (this.size == k.size) {
            int selfOffset = start;
            int otherOffset = k.start;

            for (int i = 0; i < this.size; i++) {
                if (cir[selfOffset % this.cir.length] != k.cir[otherOffset % k.cir.length])
                    return false;

                selfOffset++;
                otherOffset++;
            }
        }

        return true; // Remove this line
    }
}