package Recursion;

import java.util.Stack;

public class A8_DeleteMiddleElementOfStack {

	public static void main(String... strings) {

		Stack<Integer> al = new Stack<>();
		for (int i = 5; i >= 0; i--) {
			al.push(i); // add or push same.
		}

		System.out.println(al);

		int k = (al.size() / 2) + 1;

		delete(al, k);

		System.out.println(al);

	}

	private static void delete(Stack<Integer> al, int k) {
		if (al.isEmpty())
			return;

		if (k == 1) {
			al.pop();
			return;
		}
		int temp = al.pop();
		delete(al, k - 1);

		al.push(temp);

	}
}
