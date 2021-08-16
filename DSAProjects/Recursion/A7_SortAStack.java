package Recursion;

import java.util.ArrayList;
import java.util.Stack;

public class A7_SortAStack {

	public static void main(String... strings) {

		Stack<Integer> al = new Stack<>();
		for (int i = 5; i >= 0; i--) {
			al.push(i);
		}

		System.out.println(al);

		sort(al);

		System.out.println(al);

	}

	private static void sort(Stack<Integer> al) {

		if (al.size() == 1) {
			return;
		}

		int temp = al.pop();

		sort(al);

		insert(al, temp);

	}

	private static void insert(Stack<Integer> al, int temp) {
		if (al.isEmpty() || al.peek() <= temp) {
			al.push(temp);
			return;
		}
		int val = al.pop();

		insert(al, temp);

		al.push(val);

	}

}
