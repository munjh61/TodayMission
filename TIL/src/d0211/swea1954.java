package d0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea1954 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				int N = Integer.parseInt(br.readLine());
				int[][] arr = new int[N][N];

				int dir = 1;
				int dist = N;
				int row = 0;
				int col = -1;
				int num = 1;
				while (true) {
					// 수평
					for (int i = 0; i < N; i++) {
						col += dir;
						arr[row][col] = num++;
					}
					if (N < 0)
						break;

					N--;

					// 수직
					for (int j = 0; j < N; j++) {
						row += dir;
						arr[row][col] = num++;
					}
					if (N < 0)
						break;

					dir = -dir;
				}

				System.out.println("#" + tc);
				for (int[] rows : arr) {
					StringBuilder sb = new StringBuilder();
					for (int elem : rows) {
						sb.append(elem + " ");
					}
					System.out.println(sb.toString().trim());
				}
			} // testcase }
		} catch (IOException e) {

		}
	} // main }

}
