import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 피보나치 수 5
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int answer = fibo(N);
		
		bw.write(answer + "");
		bw.close();
	}
	
	static int fibo(int n) {
		// 기저 조건
		if (n == 0) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		// 재귀 조건
		return fibo(n - 1) + fibo(n - 2);
	}
	
}