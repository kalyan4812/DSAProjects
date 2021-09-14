package JavaTopics;

public class B8_StaticBlock3 {

	// without main method,we can print statements using static block.

	static class X {

		static {
			System.out.println("HiiiX");
			System.exit(0);
		}
	}

	static class Y {
		static int x = m1();

		public static int m1() {
			System.out.println("HiiiY");
			System.exit(0);
			return 0;
		}
	}

	static class Z {
		static Z z = new Z();
		{
			System.out.println("HiiiZ");
			System.exit(0);
		}
	}

	static class R {

		static R r = new R();

		R() {
			System.out.println("HiiiR");
			System.exit(0);
		}
	}

	public static void main(String... strings) {
		X x = new X();
		Y y=new Y();
		Z z=new Z();
		R r=new R();
	}

}
