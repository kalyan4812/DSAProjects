package LinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class C5_LruUsingLinkedListHashTable {

	static LinkedList<Integer> dl = new LinkedList<>();
	static HashSet<Integer> h = new HashSet<>();

	public static void main(String[] args) {

		C5_LruUsingLinkedListHashTable l = new C5_LruUsingLinkedListHashTable();
		l.get(10);
		l.print();
		l.get(20);
		l.print();
		l.get(10);
		l.print();
		l.get(30);
		l.print();
		l.get(40);
		l.print();
		l.get(50);
		l.print();
		l.get(30);
		l.print();
		l.get(40);
		l.print();
		l.get(60);
		l.print();
		l.get(30);
		l.print();

	}

	public  void get(Integer x) {
		if (h.contains(x)) {
			dl.remove(x);
			h.remove(x);
		} else if (dl.size() == 4) {
			int k = (int) dl.removeLast();
			h.remove(k);
		}
		h.add(x);
		dl.addFirst(x);
	}

	public  void print() {
		for (Integer i : dl) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
