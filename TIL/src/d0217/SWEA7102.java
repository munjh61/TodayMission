package d0217;

import java.util.Scanner;

public class SWEA7102 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 가운대에 있는 수가 가장 많이 나온다.
			// 0은 없으므로 1부터 짝지은다. 그러므로 + 1
			// N + M 이게 홀수면 오류남!
			StringBuilder sb = new StringBuilder();
			
			
			System.out.println("#" + tc + " " + sb.toString());
		} // tc

		sc.close();
	} // main
}