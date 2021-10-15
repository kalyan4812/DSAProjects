package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class B4_MedianOfStream {

	public static void main(String... strings) {
		int a[] = { 25, 7, 10, 15, 20 };

		median(a);
	}

	// O(nlogn)
	private static void median(int[] a) {
		PriorityQueue<Integer> p1 = new PriorityQueue<>();

		PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());

		p2.add(a[0]);
		System.out.print(a[0] + " ");

		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			if (p2.size() > p1.size()) {
				if (p2.peek() > x) {
					p1.add(p2.poll());
					p2.add(x);
				} else {
					p1.add(x);
				}
				float f = (float) ((p1.peek() + p2.peek()) / 2.0);
				System.out.print(String.format("%.2f", f) + " ");

			} else {
				if (p2.peek() >= x) {
					p2.add(x);

				} else {
					p1.add(x);
					p2.add(p1.poll());

				}

				System.out.print(p2.peek() + " ");
			}
		}
	}

	// other way.
	public static class MedianPriorityQueue {
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;

		public MedianPriorityQueue() {
			left = new PriorityQueue<>(Collections.reverseOrder());
			right = new PriorityQueue<>();
		}

		public void add(int val) {

			if (right.size() > 0 && val > right.peek()) {
				right.add(val);
			} else {
				left.add(val);
			}

			if (left.size() - right.size() == 2) {
				right.add(left.remove());
			} else if (right.size() - left.size() == 2) {
				left.add(right.remove());
			}
		}

		public int remove() {
			if (this.size() == 0) {

				System.out.println("Underflow");
				return -1;
			} else if (left.size() >= right.size()) {
				return left.remove();
			} else {
				return right.remove();
			}
		}

		public int peek() {
			if (this.size() == 0) {

				System.out.println("Underflow");
				return -1;
			} else if (left.size() >= right.size()) {
				return left.peek();
			} else {
				return right.peek();
			}
		}

		public int size() {
			return left.size() + right.size();
		}
	}

}
