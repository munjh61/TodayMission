package d0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			for (int tc = 1; tc <= 10; tc++) {
				tc = Integer.parseInt(br.readLine());
				String letter = br.readLine();
				String msg = br.readLine();
				// (replace 전 후 길이 차이) ÷ replace 문자열 길이
				int result = (msg.length() - msg.replace(letter, "").length()) / letter.length();
				System.out.println("#" + tc + " " + result);
			} // tc }
		} catch (IOException e) {

		}
	} // main }
}
