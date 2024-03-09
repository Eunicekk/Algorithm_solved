import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 수열
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		int[] array = new int[N]; // 수열
		int up = 1;
		int down = 1;
		int max = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
			if (array[i] <= array[i + 1]) {
				up++;
			}
			
			if (array[i] > array[i + 1]) {
				max = Math.max(max, up);
				up = 1;
			}
 		}
		
		for (int i = 0; i < N - 1; i++) {
			if (array[i] >= array[i + 1]) {
				down++;
			}
			
			if (array[i] < array[i + 1]) {
				max = Math.max(max, down);
				down = 1;
			}
		}
		
		max = Math.max(max, up);
		max = Math.max(max, down);
		
		bw.write(max + "");
		bw.close();
	}
	
}