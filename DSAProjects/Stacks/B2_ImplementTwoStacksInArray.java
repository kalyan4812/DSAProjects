package Stacks;

public class B2_ImplementTwoStacksInArray {

	int top1, top2;
	int cap;
	int s[];

	public B2_ImplementTwoStacksInArray(int cap) {
		top1 = -1;
		top2 = cap;
		this.cap = cap;
		s = new int[cap];
	}

	public static void main(String... strings) {
		B2_ImplementTwoStacksInArray st = new B2_ImplementTwoStacksInArray(6);
		st.push1(1);
		st.push1(2);
		st.push2(3);
		st.push2(4);
		st.display1();
		st.display2();
		st.pop1();
		st.pop2();
		st.display1();
		st.display2();
	}

	public void push1(int val) {
		if (top1 >= top2 - 1) {
			System.out.println("Stack is full");
			return;
		}
		top1++;
		s[top1] = val;

	}

	public void push2(int val) {
		if (top1 >= top2 - 1) {
			System.out.println("Stack is full");
			return;
		}
		top2--;
		s[top2] = val;

	}

	public int pop1() {
		if (top1 < 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = s[top1];
		top1--;
		return res;
	}

	public int pop2() {
		if (top2 >= cap) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = s[top2];
		top2++;
		return res;
	}

	public void display1() {
		if (top1 < 0) {
			System.out.println("Stack is Empty");

		} else {
			for (int k = top1; k >= 0; k--) {
				System.out.print(s[k] + " ");
			}
		}
		System.out.println();

	}

	public void display2() {
		if (top2 >= cap) {
			System.out.println("Stack is Empty");
		} else {
			for (int k = top2; k < cap; k++) {
				System.out.print(s[k] + " ");
			}
		}
		System.out.println();
	}
}
