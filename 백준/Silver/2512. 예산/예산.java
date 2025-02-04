import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());

		long max = 0;
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, array[i]);
		}
		
		long result = 0;
		long start = 1;
		long end = max;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (array[i] >= mid) {
					sum += mid;
				} else {
					sum += array[i];
				}
				
			}
			
			if (sum <= M) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
}