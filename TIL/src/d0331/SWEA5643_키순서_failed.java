package d0331;

import java.util.Scanner;

public class SWEA5643_키순서_failed {
	static int N; // 학생 수
	static int M; // 비교 횟수
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			dist = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j)
						dist[i][j] = INF;
				}
			}

			for (int m = 0; m < M; m++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				// a < b
				dist[a][b] = 1;
			}

			for (int k = 1; k <= N; k++) {
				for (int s = 1; s <= N; s++) {
					if (dist[s][k] == INF)
						continue;
					for (int e = 1; e <= N; e++) {
						if (dist[k][e] == INF)
							continue;
						dist[s][e] = Math.min(dist[s][e], dist[s][k] + dist[k][e]);
					}
				}
			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					if(dist[i][j] == INF)
//						System.out.print("* \t");
//					else System.out.print(dist[i][j] + "\t");
//				}
//				System.out.println();
//			}
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] == INF || dist[j][i] == INF)
						break;
					cnt++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}

	}
}
