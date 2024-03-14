import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int b1 = Integer.parseInt(st2.nextToken());
			int b2 = Integer.parseInt(st2.nextToken());
			int ball = Integer.parseInt(st2.nextToken());
			
			for (int j = b1; j <= b2; j++) {
				arr[j] = ball;
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			bw.write(arr[i] + " ");
		}
		bw.close();
	}
	
}