import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 팩토리얼 2
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		bw.write(factorial(N) + "");
		bw.close();
	}
	
	static long factorial(long N) {
		if (N <= 1) {
			return 1;
		}
		
		return N * factorial(N - 1);
	}
	
}