package BasicQuestions;

public class A3_Fibanocci {

	public static void main(String... strings) {

		fibanocci(10);
	}

	private static void fibanocci(int n) {

		int a = 0;
		int b = 1;
		System.out.print(a + "  " + b + " ");
		for (int i = 0; i < n - 2; i++) {
			int c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
}
