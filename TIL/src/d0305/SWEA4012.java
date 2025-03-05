package d0305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA4012 {
	static int[][] matrix;
	static int N;
	static boolean[] ingreedient;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			ingreedient = new boolean[N];
			list = new ArrayList<>();

			// 조합표 채우기
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				int col = 0;
				while (st.hasMoreTokens()) {
					matrix[row][col++] = Integer.parseInt(st.nextToken());
				}
			}
			// ----------
			select(0, 0);
			Collections.sort(list);
			
			if(sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ").append(list.get(0));
		}
		System.out.println(sb.toString());
		br.close();
	}

	static void select(int idx, int s) {
		// 종료 조건
		if (s == N / 2) {

			int tasteA = 0; // 음식 A
			int tasteB = 0; // 음식 B

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (ingreedient[row] && ingreedient[col])
						tasteA += matrix[row][col];
					else if (!ingreedient[row] && !ingreedient[col])
						tasteB += matrix[row][col];
				}
			}

			list.add(Math.abs(tasteA - tasteB));
			return;
		}
		if (idx == N) {
			return;
		}

		// 재귀 조건
		ingreedient[idx] = true;
		select(idx + 1, s + 1);
		ingreedient[idx] = false;
		select(idx + 1, s);
	}
}
