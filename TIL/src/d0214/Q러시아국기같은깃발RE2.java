package d0214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q러시아국기같은깃발RE2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 1; tc <= testcase; tc++) { // testcase
			int N = sc.nextInt();
			int M = sc.nextInt();
			String[][] table = new String[N][M];
			int paint = Integer.MAX_VALUE;
			// 정방향
			for (int i = 0; i < N; i++) {
				table[i] = sc.next().split("");
			}

			Map<Integer, int[]> map = new HashMap<>();

			for (int row = 0; row < N; row++) {
				map.put(row, new int [3]);//[W, B, R]
				for (int col = 0; col < M; col++) {
					int[] cnt = map.get(row);
					switch (table[row][col]) { //이미 이 색깔이 칠해져있으므로 이 색깔로 칠할 때 칠해야하는 개수가 1개씩 줄어들음
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
					map.put(row, cnt);
				}
			}
			
			
			for (int w = 0; w < N - 2; w++) { // 몇줄까지 w로 칠 할 것인가. 2줄은 남겨놔야함
				int sum = 0;
				// 칠하는 개수 세기
				for (int i = 0; i <= w; i++) {
					sum += map.get(i)[0];
				}

				for (int b = w + 1; b < N - 1; b++) {// 몇줄까지 b로 칠 할 것인가. 1줄은 남겨놔야함
					for (int i = w + 1; i <= b; i++) {
						sum += map.get(i)[1];
					}
					for (int r = b + 1; r < N; r++) {// 남기면 안됨
						sum += map.get(r)[2];
					}
					// 더 적게 칠해도 된다면 변경
					paint = paint > sum ? sum : paint;
				}
			}
			
			
			System.out.println("#"+tc+" "+paint);
		} // testcase }
		sc.close();
	} // main }
}
