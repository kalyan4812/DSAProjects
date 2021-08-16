package Recursion;

import java.util.Stack;

public class A9_ReverseAStack {

	public static void main(String... strings) {

		Stack<Integer> al = new Stack<>();
		for (int i = 5; i >= 0; i--) {
			al.push(i); // add or push same.
		}

		System.out.println(al);

		reverse(al);

		System.out.println(al);

	}

	private static void reverse(Stack<Integer> al) {

		if (al.isEmpty())
			return;
		if (al.size() == 1)
			return;

		int temp = al.pop();
		reverse(al);
		insert(al, temp);

	}

	private static void insert(Stack<Integer> al, int temp) {
		if (al.isEmpty()) {
			al.push(temp);
			return;
		}
		int val = al.pop();

		insert(al, temp);

		al.push(val);

	}
}
