package d0306;

import java.util.Scanner;

public class SWEA1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N;
		int M;
		for (int tc = 1; tc <= 10; tc++) {
			tc = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println("#" + tc + " " + pow(N, M));
		}
		sc.close();
	}

	static int pow(int N, int M) {
		if (M == 1)
			return N;
		int tmp = pow(N, M / 2);
		if (M % 2 == 1)
			return tmp * tmp * N;
		return tmp * tmp;
	}
}
