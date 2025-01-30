import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] snack = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snack);
		
		int left = 1;
		int right = snack[M-1];
		int result = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;
			
			for (int i = 0; i < M; i++) {
				count += snack[i] / mid;
			}
			
			if (count >= N) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
 		}
		
		System.out.println(result);
	}
	
}