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
	
	// since it is a complete binary tree,we can use array to store elements since in complete binary tree elements will be in
	// order without gaps.Since we are using array to represent ,we got to know left,right,parent in O(1) time.
	
	// and to insert element correct position ,we need to do swaps from bottom to  top of tree whose height is logn
	// so complexity is O(logn).

	
	//O(logn)-since we only traverse through height.(i=parent(i)).
	private static void insert(ArrayList<Integer> al, int num, int capacity) {

		if (al.size() == capacity)
			return;

		al.add(num); // first add element at last,so it full-fills complete binary tree property.
		// note if it is not a complete binary tree,to add a element at available position you need O(n) time.

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
