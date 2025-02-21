package d0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {

	public static void main(String[] args) throws IOException{
		//지그재그 i/j 에서 i와 j의 합이 같다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		br.close();
		
		int n = 1;
		while( ((n-1)*n)/2 < X ) {
			n++;
		}
		n--; // 마지막 나올 때도 +1했기 때문에 -1;
		// X 가 4라면, n = 4 - 1 = 3;
		// 대각선 시작 지점이 i 또는 j가 n이고, 대각선방향으로 X - ((n-1)*n)/2번째이다
		// n이 홀수일 경우 n/1부터 시작
		// n이 짝수일 경우 1/n부터 시작
		int i;
		int j;
		if(n % 2 == 1) {
			j = X - ((n-1)*n)/2 ;
			i = n+1-j;
		} else {
			i = X - ((n-1)*n)/2 ;
			j = n+1-i;
		}
		System.out.println(i+"/"+j);
		
	}

}
