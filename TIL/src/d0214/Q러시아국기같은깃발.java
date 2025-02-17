package d0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q러시아국기같은깃발 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) { // testcase
				// flag 크기
				String[] NM = br.readLine().split(" ");
				int N = Integer.parseInt(NM[0]); // 즐
				int M = Integer.parseInt(NM[1]); // 문자수

				Map<Integer, int[]> flag = new HashMap<>();
				// 각 int는 [W , B , R] 해당 색으로 칠했을 때 칠해야 하는 칸 개수를 뜻함
				for (int row = 0; row < N; row++) {
					String[] line = br.readLine().split("");
					for (String color : line) {
						int[] cnt = flag.getOrDefault(row, new int[] { 0, 0, 0 });
						switch (color) {
						case "W": // 이 색과 다른 색으로 바꾸려면 그만큼 더 칠해야한다. 나머지 색깔에 +1
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
						flag.put(row, cnt);
					}
				} // 줄 별 저장 끝

				int paint = Integer.MAX_VALUE;
				for (int w = 0; w < N - 2; w++) { // 몇줄까지 w로 칠 할 것인가. 2줄은 남겨놔야함
					int sum = 0;
					// 칠하는 개수 세기
					for (int i = 0; i <= w; i++) {
						sum += flag.get(i)[0];
					}

					for (int b = w + 1; b < N - 1; b++) {// 몇줄까지 b로 칠 할 것인가. 1줄은 남겨놔야함
						for (int i = w + 1; i <= b; i++) {
							sum += flag.get(i)[1];
						}
						for (int r = b + 1; r < N; r++) {// 남기면 안됨
							sum += flag.get(r)[2];
							System.out.println("w : " + w + " b : " + b + " r : " + r);
						}
						// 더 적게 칠해도 된다면 변경
						paint = paint > sum ? sum : paint;
						// System.out.println(w + " " + b + " | " + sum);
					}
				}

				System.out.println("#" + tc + " " + paint);

			} // testcase }
		} catch (IOException e) {
		}
	} // main }
}
