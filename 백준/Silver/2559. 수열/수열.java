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
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken()); // 전체 날짜의 수
		int K = Integer.parseInt(st1.nextToken()); // 연속적인 날짜의 수
		int[] date = new int[N];
		int[] sum = new int[N- K + 1];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			date[i] = Integer.parseInt(st2.nextToken());
		}
		
		for (int i = 0; i < N - K + 1; i++) {
			for (int j = i; j < i + K; j++) {
				sum[i] += date[j];
			}
			max = Math.max(max, sum[i]);
		}
		
		bw.write(max + "");
		bw.close();
	}
	
}