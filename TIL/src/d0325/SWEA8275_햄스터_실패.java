package d0325;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA8275_햄스터_실패 {
	static int N; // 우리 개수
	static int X; // 우리에 최대 몇마리
	static int M; // 경근이의 기록
	static int[] cage; // 햄스터 우리
	static boolean[] fixed; // 이미 고정되어있는지
	
	static int[] result;

	static boolean able = false;
	static int inputcnt; // 경근이의 테스트 번호
	static int l; // 방문 시작
	static int r; // 방문 끝
	static int s; // 몇 마리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			if (sb.length() != 0)
				sb.append("\n");
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			X = sc.nextInt();
			M = sc.nextInt();

			cage = new int[N];
			fixed = new boolean[N];
			result = new int[N];
			
			
			
			inputcnt = 0;
			input(sc);

			// 고정되어 있지 않은 부분 == 시험 범위 아님, 최대치로 채우기
			for (int i = 0; i < N; i++) {
				if (!fixed[i])
					result[i] = X;
			}
			
			// 가능 여부에 따라 출력이 다름
			if (able) {
				for (int i = 0; i < N; i++) {
					sb.append(result[i]);
				}
			} else {
				sb.append(-1);
			}

		}
		System.out.println(sb);
		sc.close();
	}

	// 재귀1 입력 부분
	static void input(Scanner sc) {
		System.out.println("왔다1");
		// 탈출 부분
		if (inputcnt == M) {
			result = Arrays.copyOf(cage, N);
			return;
		}
		// 재귀 부분
		l = sc.nextInt()-1; // 방문 시작, l
		r = sc.nextInt()-1; // 방문 끝, r
		s = sc.nextInt(); // 몇 마리, s
		able = false; // 가능한지 안한지 확인용
		calc(sc, l, s);
	}

	// 재귀2 조합 부분
	static void calc(Scanner sc, int idx, int remain) {
		// 탈출 부분
		if (remain == 0) {
			System.out.println("왔다2");
			able = true; // 가능하네요
			for (int i = l; i <= r; i++) { // 해당 부분 전부 고정
				fixed[i] = true;
			}
			inputcnt++;
			input(sc);
			return;
		}
		if (idx > r) {
			return;
		}

		// 재귀 부분
		int range = Math.min(remain, X);

		for (int i = 0; i <= range; i--) {
			if (!fixed[idx]) {
				fixed[idx] = true;
				cage[idx] = i;
				calc(sc, idx + 1, remain - i);
				fixed[idx] = false;
			}

		}
	}

}
