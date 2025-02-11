package d0211;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea2001 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				String line = br.readLine();
				int N = Integer.parseInt(line.split(" ")[0]);
				int M = Integer.parseInt(line.split(" ")[1]);
				//영역 저장
				int[][] arr = new int[N][N];
				for (int i = 0; i < N; i++) {
					String[] sp = br.readLine().split(" ");
					for (int j = 0; j < N; j++) {
						arr[i][j] = Integer.parseInt(sp[j]);
					}
				}
				int max = 0;
				//영역 순회
				for (int i = 0; i <= N - M; i++) {
					for (int j = 0; j <= N - M; j++) {
						int sum = 0;
						//파리채 범위 합
						for (int ii = i; ii < i + M; ii++) {
							for (int jj = j; jj < j + M; jj++) {
								sum += arr[ii][jj];
							}
						}
						max = max < sum ? sum : max;
					}
				}

				System.out.println("#" + tc + " " + max);
			} // for }

		} catch (Exception e) {

		}
	} // main }
}
