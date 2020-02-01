package Lab01;

public class LinearArray {
	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 40, 50, 60 };

		System.out.println("\n///// TEST 01: Copy Array example /////");
		int[] b = copyArray(a, a.length);
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }

		System.out.println("\n///// TEST 02: Print Reverse example /////");
		printArray(a); // This Should Print: { 10, 20, 30, 40, 50, 60 }
		printReverse(a); // This Should Print: { 60, 50, 40, 30, 20, 10 }

		System.out.println("\n///// TEST 03: Reverse Array example /////");
		reverseArray(b);
		printArray(b); // This Should Print: { 60, 50, 40, 30, 20, 10 }

		System.out.println("\n///// TEST 04: Shift Left k cell example /////");
		b = copyArray(a, a.length);
		b = shiftLeft(b, 3);
		printArray(b); // This Should Print: { 40, 50, 60, 0, 0, 0 }

		System.out.println("\n///// TEST 05: Rotate Left k cell example /////");
		b = copyArray(a, a.length);
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }
		b = rotateLeft(b, 3);
		printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 }

		System.out.println("\n///// TEST 06: Shift Right k cell example /////");
		b = copyArray(a, a.length);
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }
		b = shiftRight(b, 3);
		printArray(b); // This Should Print: { 0, 0, 0, 10, 20, 30 }

		System.out.println("\n///// TEST 07: Rotate Right k cell example /////");
		b = copyArray(a, a.length);
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }
		b = rotateRight(b, 3);
		printArray(b); // This Should Print: { 40, 50, 60, 10, 20, 30 }

		System.out.println("\n///// TEST 08: Insert example 1 /////");

		b = copyArray(a, a.length);
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }
		boolean bol = insert(b, 6, 70, 2); // This Should Print: No space Left
		System.out.println(bol); // This Should Print: false
		printArray(b); // This Should Print: { 10, 20, 30, 40, 50, 60 }

		System.out.println("\n///// TEST 09: Insert example 2 /////");
		int[] c = { 10, 20, 30, 40, 50, 0, 0 };
		printArray(c); // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
		bol = insert(c, 5, 70, 2); // This Should Print: Number of elements after insertion: 6
		System.out.println(bol); // This Should Print: true
		printArray(c); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 }

		System.out.println("\n///// TEST 10: Insert example 3 /////");
		int[] x = { 10, 20, 70, 30, 40, 50, 0 };
		printArray(x); // This Should Print: { 10, 20, 70, 30, 40, 50, 0 }
		bol = insert(x, 6, 70, 6); // This Should Print: Number of elements after insertion: 7
		System.out.println(bol); // This Should Print: true
		printArray(x); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 }

		System.out.println("\n///// TEST 11: Remove example 1 /////");

		int[] y = { 10, 20, 70, 30, 40, 50, 70 };

		printArray(y); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 }
		bol = removeAll(y, 7, 90);
		System.out.println(bol); // This Should Print: false
		printArray(y); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 }

		System.out.println("\n///// TEST 12: Remove example 2 /////");
		printArray(y); // This Should Print: { 10, 20, 70, 30, 40, 50, 70 }
		bol = removeAll(y, 7, 70);
		System.out.println(bol); // This Should Print: true
		printArray(y); // This Should Print: { 10, 20, 30, 40, 50, 0, 0 }
	}

	// Prints the contents of the source array
	public static void printArray(int[] source) {
		// TO DO
		System.out.print("{ ");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]);

			if (i < source.length - 1)
				System.out.print(", ");
		}
		System.out.println(" }");
	}

	// Prints the contents of the source array in reverse order
	public static void printReverse(int[] source) {
		// TO DO
		System.out.print("{ ");
		for (int i = source.length - 1; i >= 0; i--) {
			System.out.print(source[i]);

			if (i > 0)
				System.out.print(", ");
		}
		System.out.println(" }");
	}

	// creates a copy of the source array and returns the reference of the newly
	// created copy array
	public static int[] copyArray(int[] source, int len) {
		// TO DO
		int[] copy = new int[len];

		for (int i = 0; i < source.length; i++) {
			copy[i] = source[i];
		}

		return copy; // remove this line
	}

	// creates a reversed copy of the source array and returns the reference of the
	// newly created reversed array
	public static void reverseArray(int[] source) {
		// TO DO
		int mid = source.length / 2;
		for (int i = 0; i < mid; i++) {
			int temp = source[source.length - 1 - i];
			source[source.length - 1 - i] = source[i];
			source[i] = temp;
		}
	}

	// Shifts all the elements of the source array to the left by 'k' positions
	// Returns the updated array
	public static int[] shiftLeft(int[] source, int k) {
		// TO DO
		int[] copy = copyArray(source, source.length);
		for (int i = k, j = 0; i < copy.length + k; i++) {
			if (i < copy.length)
				copy[j++] = copy[i];
			else
				copy[j++] = 0;
		}
		
		return copy; // remove this line
	}

	public static int[] shiftLeft(int[] source, int start, int k) {
		int[] copy = copyArray(source, source.length);

		int from = start + k;
		int to = start;

		for (int i = 0; i < copy.length - k - start; i++) {
			copy[to] = copy[from];
			to++;
			from++;
		}

		for(int j = 0; j < k; j++){
			copy[copy.length - 1 - j] = 0;
		}

		return copy;
	}

	// Rotates all the elements of the source array to the left by 'k' positions
	// Returns the updated array
	public static int[] rotateLeft(int[] source, int k) {
		// TO DO
		int[] leftShifted = shiftLeft(source, 0, k);

		for(int i = 0; i < k; i++){
			leftShifted[leftShifted.length - 1 - (k - 1) + i] = source[i];
		}

		return leftShifted;
	}

	// Shifts all the elements of the source array to the right by 'k' positions
	// Returns the updated array
	public static int[] shiftRight(int[] source, int k) {
		// TO DO
		int[] copy = copyArray(source, source.length);
		for (int i = 0, j = 0; i < source.length; i++) {
			if (i < k)
				copy[i] = 0;
			else
				copy[i] = source[j++];
		}
		return copy; // remove this line
	}

	public static int[] shiftRight(int[] source, int start, int k) {
		int[] copy = copyArray(source, source.length);

		int from = copy.length - 1 - k;
		int to = copy.length - 1;

		for(int i = 0; i < copy.length - k - start; i++){
			copy[to] = copy[from];
			to--;
			from--;
		}

		for(int j = start; j < start + k; j++){
			copy[j] = 0;
		}

		return copy;
	}

	// Rotates all the elements of the source array to the right by 'k' positions
	// Returns the updated array
	public static int[] rotateRight(int[] source, int k) {
		// TO DO
		int[] rightShifted = shiftRight(source, 0, k);

		for(int i = 0; i < k; i++){
			rightShifted[i] = source[source.length - 1 - (k - 1) + i];
		}

		return rightShifted;
	}

	/**
	 * @return true if insertion is successful; @return false otherwise
	 * @param arr   the reference to the linear array
	 * @param size  the number of elements that exists in the array.
	 *              size<=arr.length
	 * @param elem  the element that is to be inserted
	 * @param index the index in which the element is required to be inserted if
	 *              insertion is not successful due to lack space, print "No space
	 *              Left" if given index is invalid, print "Invalid Index" if
	 *              insertion is successful, print the 'Number of elements after
	 *              insertion' is completed
	 */
	public static boolean insert(int[] arr, int size, int elem, int index) {
		// TO DO
		if(index > 0 || index < arr.length)
		{
			if(size <= arr.length){
				int[] rightShifted = shiftRight(arr, index, 1);
				rightShifted[index] = elem;

				printArray(rightShifted);

				return true;
			}else {
				System.out.println("No space left.");
			}
		}else {
			System.out.println("Invalid Index.");
		}

		return false;
	}

	/**
	 * removes all the occurences of the given element
	 * 
	 * @param arr  the reference to the linear array
	 * @param size the number of elements that exists in the array. size<=arr.length
	 * @param elem the element to be removed
	 * @return true if removal is successful; return false otherwise if removal is
	 *         successful, print the 'Number of elements after removal' is completed
	 */
	public static boolean removeAll(int[] arr, int size, int elem) {
		// TO DO
		int count = 0;

		for (int i = 0; i < size; i++) {
			if (arr[i] == elem) {
				arr = shiftLeft(arr, i, 1);
				count++;
			}
		}

		if (count > 0) {
			System.out.println("Count: " + count);

			printArray(arr);

			return true;
		}

		return false; // remove this line
	}
}