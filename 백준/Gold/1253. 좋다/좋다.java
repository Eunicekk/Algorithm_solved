import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N-1;
			
			while (start < end) {
				if (start == i) {
					start++;
					continue;
				}
				
				if (end == i) {
					end--;
					continue;
				}
				
				int sum = numbers[start] + numbers[end];
				
				if (numbers[i] == sum) {
					count++;
					break;
				} else if (numbers[i] > sum) {
					start++;
				} else if (numbers[i] < sum) {
					end--;
				}
			}
		}
		
		System.out.println(count);
	}
	
}