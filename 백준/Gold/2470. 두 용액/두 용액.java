import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int start = 0;
		int end = N - 1;
		int minStart = 0;
		int minEnd = 0;
		int minSum = Integer.MAX_VALUE;
		
		while (start < end) {
			int sum = array[start] + array[end];
			
			if (Math.abs(sum) <= minSum) {
				minSum = Math.abs(sum);
				minStart = start;
				minEnd = end;
			}
			
			if (sum > 0) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(array[minStart] + " " + array[minEnd]);
	}
	
}