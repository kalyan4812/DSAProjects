package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class A5_DecreaseKey {

	public static void main(String... strings) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 20, 40, 80, 100, 70));

		decreaseKey(al, 3, 5); // insert value 5 at index(i)=3 and make it a valid heap.

		System.out.print(al.toString());
	}

	// O(logn)=O(h)
	private static void decreaseKey(ArrayList<Integer> al, int index, int val) {

		al.set(index, val);

		for (int i = index; i != 0 && al.get(parent(i)) > al.get(i);) {

			// swap if child>parent
			int temp = al.get(i);
			al.set(i, al.get(parent(i)));
			al.set(parent(i), temp);

			i = parent(i);
		}

	}

	static int parent(int i) {
		return (i - 1) / 2;
	}
}
