import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] array = new int[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, array[i]);
		}
		
		long result = 0;
		long start = 1;
		long end = max;
		
		while (start <= end) {
			long mid = start + (end - start) / 2;
			long count = 0;
			
			for (int i = 0; i < K; i++) {
				count += (array[i] / mid);
			}
			
			if (count >= N) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
}