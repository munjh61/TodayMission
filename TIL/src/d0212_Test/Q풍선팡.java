package d0212_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q풍선팡 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				// 테이블 저장
				String[] str = br.readLine().split(" ");
				int N = Integer.parseInt(str[0]);
				int M = Integer.parseInt(str[1]);
				int[][] table = new int[N][M];
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int j = 0;
					while (st.hasMoreTokens()) {
						table[i][j++] = Integer.parseInt(st.nextToken());
					}
				} // 저장 }

				int max = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int sum = table[i][j];

						// 상
						int d = 1;
						while (i - d >= 0 && d <= table[i][j]) {
							sum += table[i - d][j];
							d++;
						}
						// 하
						d = 1;
						while (i + d < N && d <= table[i][j]) {
							sum += table[i + d][j];
							d++;
						}
						// 좌
						d = 1;
						while (j - d >= 0 && d <= table[i][j]) {
							sum += table[i][j - d];
							d++;
						}
						// 우
						d = 1;
						while (j + d < M && d <= table[i][j]) {
							sum += table[i][j + d];
							d++;
						}
						max = max < sum ? sum : max;
					}
				}

				System.out.println("#" + tc + " " + max);

			} // testcase }
		} catch (IOException e) {

		}
	} // main}
}
