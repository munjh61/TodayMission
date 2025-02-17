package d0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1989 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int testcase = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= testcase; tc++) {
				StringBuilder sb = new StringBuilder();
				sb.append(br.readLine().trim());
				String reverse = sb.reverse().toString();
				sb.reverse();
				int result = 0;
				if(sb.toString().equals(reverse)) {
					result = 1;
				}
				System.out.println("#"+tc+" "+result);
			} // testcase }
		} catch (IOException e) {

		}
	} // main}
}
