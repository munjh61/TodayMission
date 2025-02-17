package d0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			for(int tc = 1 ; tc <= 10 ; tc ++) {
				int result = 0;
				
				int dump = Integer.parseInt(br.readLine());
				int[] arr = new int[100];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 0 ; i < 100; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				int[] arrSort = Arrays.copyOf(arr, arr.length);
				
				for(int i = 0 ; i < dump ; i++) {
					Arrays.sort(arrSort);
					for(int j = 0 ; j < arr.length ; j++) {
						if(arr[j] == arrSort[0]) {
							arr[j]++;
							arrSort[0]++;
							break; 
						}
					}
					for(int j = 0 ; j < arr.length ; j++) {
						if(arr[j] == arrSort[99]) {
							arr[j]--;
							arrSort[99]--;
							break;
						}
					}
				}
				
				Arrays.sort(arr);
				result = arr[99]-arr[0];
				System.out.println("#"+tc+" "+ result);
			} // text case }
				
		} catch (IOException e) {
			
		}
		
	} //main }

}
