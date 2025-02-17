package d0214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q러시아국기같은깃발RE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) { // testcase
			int N = sc.nextInt();
			int M = sc.nextInt();
			String[][] table1 = new String[N][M];
			String[][] table2 = new String[M][N];
			int paint = Integer.MAX_VALUE;
			// 정방향
			for (int i = 0; i < N; i++) {
				table1[i] = sc.next().split("");
			}

			Map<Integer, int[]> map1 = new HashMap<>();

			for (int row = 0; row < N; row++) {
				map1.put(row, new int [3]);//[W, B, R]
				for (int col = 0; col < M; col++) {
					int[] cnt = map1.get(row);
					switch (table1[row][col]) { //이미 이 색깔이 칠해져있으므로 이 색깔로 칠할 때 칠해야하는 개수가 1개씩 줄어들음
					case "W":
						cnt[1]++;
						cnt[2]++;
						break;
					case "B":
						cnt[0]++;
						cnt[2]++;
						break;
					case "R":
						cnt[0]++;
						cnt[1]++;
					}
					map1.put(row, cnt);
				}
			}
			
			
			for (int w = 0; w < N - 2; w++) { // 몇줄까지 w로 칠 할 것인가. 2줄은 남겨놔야함
				int sum = 0;
				// 칠하는 개수 세기
				for (int i = 0; i <= w; i++) {
					sum += map1.get(i)[0];
				}

				for (int b = w + 1; b < N - 1; b++) {// 몇줄까지 b로 칠 할 것인가. 1줄은 남겨놔야함
					for (int i = w + 1; i <= b; i++) {
						sum += map1.get(i)[1];
					}
					for (int r = b + 1; r < N; r++) {// 남기면 안됨
						sum += map1.get(r)[2];
					}
					// 더 적게 칠해도 된다면 변경
					paint = paint > sum ? sum : paint;
				}
			}
			/*
			// 반시계로 돌림 ---------------------------------------------
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					table2[M - 1 - i][j] = table1[j][i];
				}
			}
			
			Map<Integer, int[]> map2 = new HashMap<>();
			
			for (int row = 0; row < M; row++) {
				map2.put(row, new int [3]);//[W, B, R]
				for (int col = 0; col < N; col++) {
					int[] cnt = map2.get(row);
					switch (table2[row][col]) { //이미 이 색깔이 칠해져있으므로 이 색깔로 칠할 때 칠해야하는 개수가 1개씩 줄어들음
					case "W":
						cnt[1]++;
						cnt[2]++;
						break;
					case "B":
						cnt[0]++;
						cnt[2]++;
						break;
					case "R":
						cnt[0]++;
						cnt[1]++;
					}
					map2.put(row, cnt);
				}
			}
			for (int w = 0; w < M - 2; w++) { // 몇줄까지 w로 칠 할 것인가. 2줄은 남겨놔야함
				int sum = 0;
				// 칠하는 개수 세기
				for (int i = 0; i <= w; i++) {
					sum += map2.get(i)[0];
				}

				for (int b = w + 1; b < M - 1; b++) {// 몇줄까지 b로 칠 할 것인가. 1줄은 남겨놔야함
					for (int i = w + 1; i <= b; i++) {
						sum += map2.get(i)[1];
					}
					for (int r = b + 1; r < M; r++) {// 남기면 안됨
						sum += map2.get(r)[2];
					}
					// 더 적게 칠해도 된다면 변경
					paint = paint > sum ? sum : paint;
				}
			}
			*/
			
			System.out.println("#"+tc+" "+paint);
		} // testcase }
	} // main }
}
