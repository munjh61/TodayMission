package d0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			for (int tc = 1; tc <= 10; tc++) {
				tc = Integer.parseInt(br.readLine());
				// arr 데이터 넣기
				int[][] arr = new int[100][100];
				for (int i = 0; i < 100; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int j = 0;
					while (st.hasMoreTokens()) {
						arr[i][j] = Integer.parseInt(st.nextToken());
						j++;
					}
				}
				// 도착지점에서 역으로 올라감
				// 도착지점 찾기
				int row = 99;
				int col = -1;
				for (int j = 0; j < 100; j++) {
					if (arr[99][j] == 2) {
						col = j;
					}
				}
				String dir = "up";
				while (row > 0) {
					if (col > 0 && dir != "right" && arr[row][col - 1] == 1) { // 왼쪽으로
						col--;
						dir = "left";
						continue;
					}
					if (col < 99 && dir != "left" && arr[row][col + 1] == 1) { // 오른쪽으로
						col++;
						dir = "right";
						continue;
					}
					row--;
					dir = "up";
				}

				System.out.println("#" + tc + " " + col);
			} // for }
		} catch (IOException e) {

		}
	} // main }
}
