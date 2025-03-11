package d0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1497 {
	static boolean able = false;
	static int N;
	static int M;
	static long[] guitar;
	static boolean[] select;
	static long maximum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		// 초기화 -----------------------
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		guitar = new long[N];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			long song = 0;
			for (int j = 0; j < M; j++) {
				song *= 2;
				if (str[1].charAt(j) == 'Y') {
					song++;
				}
			}
			guitar[i] = song;
		}
		br.close();

		// 계산 -----------------------
		maximum = findmax();
		if (maximum == 0) {
			System.out.println(-1);
			return;
		}

		int result = -1;
		for (int i = 1; i <= N; i++) {
			buy(0, 0, i);
			if (able) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}

	static void buy(int idx, int sidx, int maxidx) {
		// 탈출
		if (sidx == maxidx) {
			calc();
			return;
		} else if (sidx == N || idx == N)
			return;

		// 재귀
		select[idx] = true;
		buy(idx + 1, sidx + 1, maxidx);
		select[idx] = false;
		buy(idx + 1, sidx, maxidx);

	}

	static void calc() {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (select[i]) {
				sum |= guitar[i];
			}
		}
		if (sum == maximum)
			able = true;
	}

	static long findmax() {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum |= guitar[i];
		}
		return sum;
	}
}
