package d0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1970_쉬운거스름돈 {

	// dp로 풀어보기
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 50,000 원, 10,000 원, 5,000 원 ,1,000 원 ,500 원 ,100 원 ,50 원 ,10 원
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Pay[] pay = new Pay[1000001];
		for (int i = 0; i < 1000001; i++) {
			pay[i] = new Pay();
		}
		pay[10].w10 = 1;
		pay[50].w50 = 1;
		pay[100].w100 = 1;
		pay[500].w500 = 1;
		pay[1000].w1000 = 1;
		pay[5000].w5000 = 1;
		pay[10000].w10000 = 1;
		pay[50000].w50000 = 1;
		for (int i = 10; i <= 1000000; i += 10) {
			Pay minPay = new Pay();
			if (i >= 50000) {
				minPay.w50000 = pay[i - 50000].w50000 + 1;
			}
			if (i >= 10000) {
				if (i % 50000 >= 10000)
					minPay.w10000 = pay[i - 10000].w10000 + 1;
			}
			if (i >= 5000) {
				if (i % 10000 >= 5000)
					minPay.w5000 = pay[i - 5000].w5000 + 1;
			}
			if (i >= 1000) {
				if (i % 5000 >= 1000)
					minPay.w1000 = pay[i - 1000].w1000 + 1;
			}
			if (i >= 500) {
				if (i % 1000 >= 500)
					minPay.w500 = pay[i - 500].w500 + 1;
			}
			if (i >= 100) {
				if (i % 500 >= 100)
					minPay.w100 = pay[i - 100].w100 + 1;
			}
			if (i >= 50) {
				if (i % 100 >= 50)
					minPay.w50 = pay[i - 50].w50 + 1;
			}
			if (i >= 10) {
				if (i % 50 >= 10)
					minPay.w10 = pay[i - 10].w10 + 1;
			}
			pay[i] = minPay;
		}
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append("\n");
			sb.append(pay[N].w50000).append(" ");
			sb.append(pay[N].w10000).append(" ");
			sb.append(pay[N].w5000).append(" ");
			sb.append(pay[N].w1000).append(" ");
			sb.append(pay[N].w500).append(" ");
			sb.append(pay[N].w100).append(" ");
			sb.append(pay[N].w50).append(" ");
			sb.append(pay[N].w10).append("\n");
		}
		System.out.println(sb);
		
	}

	static class Pay {
		int w50000, w10000, w5000, w1000, w500, w100, w50, w10;
	}
}
