package Stacks;

public class A1_StackUsingArray implements A0_MyStack {
	
	
	//All are O(1),but disadvantage is we should specify stack size before.

	int[] st;
	int count;
	int cap;

	public A1_StackUsingArray(int cap) {
		st = new int[cap];
		count = 0;
		this.cap = cap;
	}

	public static void main(String... strings) {
		A1_StackUsingArray s = new A1_StackUsingArray(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
		System.out.println(s.getSize());
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();

		s.display();

	}

	@Override
	public void push(int val) {
		if (count == cap) {
			System.out.println("Stack is full");
			return;
		}
		st[count] = val;
		count++;

	}

	@Override
	public int getSize() {

		return count;
	}

	@Override
	public boolean isEmpty() {
		if (getSize() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int pop() {
		if (count == 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int res = st[count - 1];
		count--;
		return res;
	}

	@Override
	public int peek() {

		return st[count - 1];
	}

	@Override
	public void display() {
		if (count == 0) {
			System.out.println("Stack is Empty");

		} else {
			for (int k = count - 1; k >= 0; k--) {
				System.out.print(st[k] + " ");
			}
		}
		System.out.println();

	}

}
