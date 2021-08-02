package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A2_BinaryHeapInsert {

	public static void main(String... strings) {

		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 20, 15, 40, 50, 100, 25, 45));

		// MinHeap ,every node is smaller than its descendants and it should be a
		// complete Binary tree.
		// so while inserting we should maintain these two properties.

		insert(al, 12, 10);
		
		System.out.print(al.toString());

	}

	
	//O(logn)-since we only traverse through height.(i=parent(i)).
	private static void insert(ArrayList<Integer> al, int num, int capacity) {

		if (al.size() == capacity)
			return;

		al.add(num); // first add element at last,so it full-fills complete binary tree property.

		for (int i = al.size() - 1; i != 0 && al.get(parent(i)) > al.get(i);) {

			//swap if child>parent
			int temp = al.get(i);
			al.set(i, al.get(parent(i)));
			al.set(parent(i), temp);

			i = parent(i);
		}

	}

	int left(int i) { // i=level ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2 * i + 1);
	}

	int right(int i) {
		return (2 * i + 2);
	}

	static int parent(int i) {
		return (i - 1) / 2;
	}

}
