package Arrays;

// elemnt which occurs >n/2 times
public class B8_MajorityElement {
	public static void main(String... strings) {
		int a[] = { 1, 1, 1, 3, 2, 2, 2 };
		System.out.println(getElement(a));
		System.out.println(getElementOtherWay(a));
		getElementnby3times(a);
	}

//o(n) voting alogirithm 2.
	private static void getElementnby3times(int[] a) {
		int count1 = 0;
		int count2 = 0;
		int element1 = -1, element2 = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == element1) {
				count1++;
			} else if (a[i] == element2) {
				count2++;
			} else if (count1 == 0) {
				element1 = a[i];
				count1 = 1;
			} else if (count2 == 0) {
				element2 = a[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		checkMajority(element1, element2, a);

	}

	private static void checkMajority(int element1, int element2, int[] a) {
		int c1 = 0, c2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == element1) {
				c1++;
			}
			if (a[i] == element2) {
				c2++;
			}
		}
		if (c1 > a.length / 3) {
			System.out.print(element1 + " ");
		}
		if (c2 > a.length / 3) {
			System.out.print(element2);
		}

	}

//o(n) voting algorithm
	private static String getElementOtherWay(int[] a) {
		int count = 0;
		int melement = 0;
		for (int i = 0; i < a.length; i++) {
			if (count == 0) {
				melement = a[i];
			}
			if (a[i] == melement) {
				count++;
			} else {
				count--;
			}
		}
		return check(melement, a);

	}

	private static String check(int melement, int[] a) {
		int c1 = 0;
		for (int i = 0; i < a.length; i++) {
			if (melement == a[i]) {
				c1++;
			}
		}
		if (c1 > a.length / 2) {
			return melement + "";
		} else {
			return "No majority Element";
		}
	}

//O(n2)
	private static String getElement(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int count = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count > a.length / 2) {
				return a[i] + "";
			}
		}
		return "No majority Element";
	}
}
