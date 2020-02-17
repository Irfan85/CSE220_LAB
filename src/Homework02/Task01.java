package Homework02;

import java.util.Arrays;

public class Task01 {
	public static void main(String[] args) {
		int[] a = {1, 2, 2, 2, 8, 1, 5, 10 ,2 ,5 , 7, 1, 1, 1, 3};
		int[] b = {2, 3, 4, 5, 2, 1, 10, 1, 2, 2, 4};

		int[] c = union(a, b);

		System.out.println(Arrays.toString(c));
	}
	
	public static int[] union(int[] a, int[] b) {
		Object[] tempC = new Object[a.length + b.length];
		int tempCount = 0;
		
		for(int i = 1; i < a.length; i++) {
			boolean isNew01 = true;
			boolean isNew02 = true;

			if(a[i - 1] != a[i]) {
				for(int j = 0; j < tempCount; j++) {
					if ((int) tempC[j] == a[i - 1])
						isNew01 = false;

					if ((int) tempC[j] == a[i])
						isNew02 = false;
				}
					
				if(isNew01)
					tempC[tempCount++] = a[i - 1];

				if(isNew02)
					tempC[tempCount++] = a[i];
			}
		}

		for(int i = 1; i < b.length; i++) {
			boolean isNew01 = true;
			boolean isNew02 = true;

			if(b[i - 1] != b[i]) {
				for(int j = 0; j < tempCount; j++) {
					if ((int) tempC[j] == b[i - 1])
						isNew01 = false;

					if ((int) tempC[j] == b[i])
						isNew02 = false;
				}

				if(isNew01)
					tempC[tempCount++] = b[i - 1];

				if(isNew02)
					tempC[tempCount++] = b[i];
			}
		}

		int[] c = new int[tempCount];

		for(int i = 0; i < tempCount; i++){
			c[i] = (int) tempC[i];
		}
		
		return c;
	}
}


