import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 수들의 합 (5)
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			array[i] = i;
		}
		
		int sum = 0;
		int count = 0;
		
		out: for (int i = 1; i <= N; i++) {
			sum = 0;
			
			for (int j = i; j <= N; j++) {
				sum += array[j];
				
				if (sum == N) {
					count++;
					continue out;
				} else if (sum > N) {
					continue out;
				}
			}
		}
		
		System.out.println(count);
	}
	
}
