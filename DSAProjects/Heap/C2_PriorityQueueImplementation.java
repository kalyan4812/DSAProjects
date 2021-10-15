package Heap;

import java.util.ArrayList;

public class C2_PriorityQueueImplementation {

	static ArrayList<Integer> data;

	public C2_PriorityQueueImplementation() {
		data = new ArrayList<>();
	}

	public void add(int val) {
		data.add(val);

		int k = data.size() - 1;

		upheapify(k);

	}

	public static void upheapify(int i) {
		if (i == 0) {
			return;
		}
		int p = parent(i);

		if (data.get(p) > data.get(i)) {
			swap(i, p);
			upheapify(p);
		}

	}

	public static void swap(int i, int p) {
		int x1 = data.get(i);
		int x2 = data.get(p);
		data.set(i, x2);
		data.set(p, x1);
	}

	public int remove() {
		if (this.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		int x = data.get(0);
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		downheapify(0);

		return x;

	}

	public static void downheapify(int i) {

		int lc = left(i);
		int rc = right(i);

		int min = i;
		if (lc < data.size() && data.get(lc) < data.get(min)) {
			min = lc;
		}

		if (rc < data.size() && data.get(rc) < data.get(min)) {
			min = rc;
		}

		if (i != min) {
			swap(i, min);
			downheapify(min);
		}

	}

	public int peek() {
		if (this.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	static int left(int i) { // i=level ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2 * i + 1);
	}

	static int right(int i) {
		return (2 * i + 2);
	}

	static int parent(int i) {
		return (i - 1) / 2;
	}
}
