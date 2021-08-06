package BitManipulation;

public class A2_Conversion {

	public static void main(String... strings) {
		int i = 10;

		String binary = converDecimalToBinary(10);
		System.out.println(binary);
		System.out.println(Integer.toBinaryString(10)); // Java Inbuilt

		String decimal = convertBinaryToDecimal(binary);
		System.out.println(decimal);
		System.out.println(Integer.parseInt(binary, 2));// Java Inbuilt
		
		
		
	}

	
	//O(n)
	private static String convertBinaryToDecimal(String binary) {

		int sum = 0;
		char c[] = binary.toCharArray();
		int mul = 1;
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] == '1') {
				sum = sum + mul;
			}
			mul = mul * 2;
		}
		return sum + "";
	}

	// logn
	private static String converDecimalToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 2);
			n = n / 2;
		}
		return sb.reverse().toString();
	}
}
