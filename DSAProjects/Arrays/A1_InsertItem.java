package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class A1_InsertItem {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int capacity = 6;
		System.out.println("ENter number to insert");
		int item = sc.nextInt();
		System.out.println("ENter position to insert in array of size :" + capacity);
		int pos = sc.nextInt();

		int a[] = new int[capacity];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;

		if (add(item, pos, capacity, 4, a)) {

			for (int i : a) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

	private static boolean add(int item, int pos, int capacity, int size, int[] a2) {
		if (capacity == size) {
			System.out.println("Array is full");
			return false;
		}
		if (pos > a2.length) {
			System.out.println("ENter a valid position");
			return false;
		}
		pos = pos - 1;
		for (int x = size - 1; x >= pos; x--) {
			a2[x + 1] = a2[x];
		}
		a2[pos] = item;
		return true;

	}

}
