package ImportantProblems;

public class A3_DesignTicTacToe {

	public static void main(String...s) {
		String k[]={"X0X",
				 ".0.",
				 ".X."};
		solve(k);
	}
	// analyze the state of tic tac toe board.
	static void solve(String s[]) {
		int rx[] = new int[3];
		int cx[] = new int[3];
		int ry[] = new int[3];
		int cy[] = new int[3];

		int d0x = 0, d1x = 0, d0y = 0, d1y = 0;

		int x = 0, y = 0;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				char c = s[i].charAt(j);

				if (c == 'X') {
					cx[j]++;
					rx[i]++;
					if (i == j) {
						d0x++;
					}
					if (i + j == 2) {
						d1x++;
					}
					x++;
				} else if (c == '0') {
					cy[j]++;
					ry[i]++;
					if (i == j) {
						d0y++;
					}
					if (i + j == 2) {
						d1y++;
					}
					y++;
				}

			}
		}

		boolean xwin = false, ywin = false;

		if (rx[0] == 3 || rx[1] == 2 || rx[2] == 3 || cx[0] == 3 || cx[1] == 3 || cx[2] == 3 || d0x == 3 || d1x == 3) {
			xwin = true;
		}

		if (ry[0] == 3 || ry[1] == 2 || ry[2] == 3 || cy[0] == 3 || cy[1] == 3 || cy[2] == 3 || d0y == 3 || d1y == 3) {
			ywin = true;
		}

		if ((xwin && ywin) || (y > x) || Math.abs(x - y) > 1 || (xwin && y == x) || (ywin && x == y + 1)) {
			System.out.println("illegal");
		}

		else if (xwin || ywin || x + y == 9) {

			if (xwin) {
				System.out.println("the first player won");
			} else if (ywin) {
				System.out.println("the second player won");
			} else {
				System.out.println("draw");
			}

		} else {
			if (x > y) {
				System.out.println("second person chance");
			} else {
				System.out.println("first person chance");
			}

		}

	}

}
