package Stacks;

import java.util.Arrays;

public class B3_ImplementKStacksInArray {

	int[] s, top, next;
	int cap;
	static int freeTop;
	int k;

	// k stacks : 0,1,2,... k-1;

	public B3_ImplementKStacksInArray(int k, int cap) {
		s = new int[cap];
		this.cap = cap;
		this.k = k;

		top = new int[k];
		Arrays.fill(top, -1);

		next = new int[cap];
		for (int i = 0; i < cap - 1; i++) {
			next[i] = i + 1;
		}
		next[cap - 1] = -1;

		freeTop = 0; // points to next array .

	}

	public static void main(String... strings) {
		B3_ImplementKStacksInArray st = new B3_ImplementKStacksInArray(4, 10);
		st.push(1, 1);
		st.push(2, 1);
		st.push(4, 2);
		st.push(5, 2);
		st.push(7, 3);
		st.push(8, 3);

		System.out.println(st.pop(1));
		System.out.println(st.pop(2));
		System.out.println(st.pop(3));

		st.push(10, 0);
		st.push(20, 0);
		st.push(30, 0);
		st.push(40, 0);
		st.push(50, 0);
		st.push(60, 0);
		st.push(70, 0);
		st.push(80, 0);
		System.out.println(st.pop(0));

	}

	public void push(int val, int stack_num) {
		if (stack_num > k - 1) {
			System.out.println("Please enter valid stack number");
			return;
		}

		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		int p = freeTop;
		s[p] = val;

		freeTop = next[p];
		next[p] = top[stack_num];
		top[stack_num] = p;

	}

	public int pop(int stack_num) {
		if (isEmpty(stack_num)) {
			System.out.println("Stack " + stack_num + " is empty");
			return Integer.MAX_VALUE;
		}
		int p = top[stack_num];
		top[stack_num] = next[p];
		next[p] = freeTop;
		freeTop = p;

		return s[p];
	}

	private boolean isEmpty(int stack_num) {
		return (top[stack_num] == -1);
	}

	static boolean isFull() {
		return (freeTop == -1);
	}
}
