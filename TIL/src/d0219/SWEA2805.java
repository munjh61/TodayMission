package d0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N]; // farm 선언
			for (int i = 0; i < N; i++) { // farm 초기화
				String line = br.readLine();
				int j = 0;
				for (char ch : line.toCharArray()) {
					farm[i][j++] = ch - '0';
				}
			} // farm 초기화 }

			int down = 0;
			int up = N / 2;
			int m = N / 2; // 중앙 idx
			int sum = 0;
			
			for (int row = 0; row < N; row++) {
				sum += farm[row][m];
				if (row < m) { // ▲
					for(int d = 1 ; d <= down; d++) {
						sum += farm[row][m+d];
						sum += farm[row][m-d];
					}
					down++;
				} else { // ▼
					for(int d = up ; d > 0 ; d--) {
						sum += farm[row][m+d];
						sum += farm[row][m-d];
					}
					up--;
				}
			}

			System.out.println("#" + tc + " "+sum);
		} // tc}

		br.close();
	}

}
