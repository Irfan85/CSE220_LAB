package Lab03;

public class TestCircularArray {

	String[] cir;
	int size;
	int start;

	public TestCircularArray(String[] lin, int st, int sz) {
		// Initialize the gloabal variables with the local ones
		// For the array, please copy the elements one by one from lin to cir
		// DO NO copy the address
		// Copy lin[0] to cir[st]

		// TO DO
		this.start = st;
		this.size = sz;
		this.cir = new String[lin.length];

		for (int i = 0, j = start; i < size; i++) {
			cir[j % cir.length] = lin[i];
			j++;
		}

		display();

	}

	public void sort() {
		// Sort the cir array using bubble/selection sort
		// Alert! The numbers in the array are in Strings
		// convert them to integer first
		// hint: Integet.parseInt()

		// TO DO
		for (int i = 0; i < size; i++) {
			int preOffset = start;
			int offset = start + 1;
			int swapCount = 0;

			for (int j = 0; j < size - 1; j++) {
				int num1 = Integer.parseInt(cir[preOffset % cir.length]);
				int num2 = Integer.parseInt(cir[offset % cir.length]);

				if (num1 > num2) {
					String temp = cir[preOffset % cir.length];
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

		display();
	}

	public int countOdd() {
		/*
		 * From the cir array, you have to count the number of odd numbers. It is not as
		 * easy as it looks. Firstly, notice that the numbers are given as strings. To
		 * determine whether a number is odd,you first have to sum up the digits. For
		 * example if one number is "234", you have to find the result of 2+3+4. If the
		 * summation is odd then consider the number as odd. Then return the count.
		 */

		// TO DO
		int count = 0;

		for (int i = 0, j = start; i < size; i++) {
			String number = cir[j % cir.length];
			int sum = 0;
			for (int k = 0; k < number.length(); k++) {
				sum += Integer.parseInt(number.charAt(k) + "");
			}

			if (sum % 2 != 0)
				count++;

			j++;
		}

		return count;
	}

	public int countEven() {
		/*
		 * From the cir array, you have to count the number of even numbers. It is not
		 * as easy as it looks. Firstly, notice that the numbers are given as strings.
		 * To determine whether a number is even, you first have to sum up the digits.
		 * For example if one number is "234", you have to find the result of 2+3+4. If
		 * the summation is even then consider the number as even. Then return the
		 * count.
		 */

		// TO DO
		int count = 0;

		for (int i = 0, j = start; i < size; i++) {
			String number = cir[j % cir.length];
			int sum = 0;
			for (int k = 0; k < number.length(); k++) {
				sum += Integer.parseInt(number.charAt(k) + "");
			}

			if (sum % 2 == 0)
				count++;

			j++;
		}

		return count;
	}

	public void insert(String item, int offset) throws CircularArrayException {
		/*
		 * If there are no empty spaces, throw CircularArrayException This class must be
		 * created you must createhe CircularArrayException object send the name of the
		 * particular exception as String in the constructor one of them is done for you
		 * 
		 * If there is/are empty space(s), insert using LEFT shift. Offset means how far
		 * from start. The index has been calculated for you. Offset cannot be more than
		 * size Note that the element pointed by start will also shift, hence change the
		 * start at the end increment size
		 */

		if (offset < 0 || offset > size) {
			throw new CircularArrayException("Invalid offset");
		}

		if (size == cir.length) {
			throw new CircularArrayException("Array full");
		}

		int idx = (start + offset) % cir.length;

		// TO DO
		int nShifts = offset + 1;
		int from = start;
		int to = (start + cir.length - 1) % cir.length;

		for (int i = 0; i < nShifts; i++) {
			cir[to] = cir[from];
			to = from;

			from = (from + 1) % cir.length;
		}

		cir[idx] = item;

		start--;
		if (start == -1)
			start = cir.length - 1;

		size++;
		display();
	}

	public String delete(int offset) throws CircularArrayException {
		/*
		 * If there are no empty spaces, throw CircularArrayException This class must be
		 * created you must send the name of the particular exception as String in the
		 * constructor shown in insert()
		 * 
		 * Delete using right shift. Note that the element pointed by start will also
		 * shift, hence change the start at the end decrement size return the delete
		 * element
		 */

		// TO DO
		if (offset < 0 || offset > size)
			throw new CircularArrayException("Invalid offset");

		int from = (start + offset - 1) % cir.length;
		int to = (start + offset) % cir.length;

		for (int i = 0; i < offset; i++) {
			cir[to] = cir[from];

			to = from;

			from--;
			if (from == -1)
				from = cir.length - 1;
		}

		cir[to] = null;

		start = (start + 1) % cir.length;
		size--;

		display();
		return null;
	}

	public void display() {
		int i = 0;
		int st = start;
		while (i < size) {
			System.out.print(cir[st] + " ");
			i++;
			st = (st + 1) % cir.length;
		}
		System.out.println();
	}

}