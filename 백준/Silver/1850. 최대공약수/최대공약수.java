import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대공약수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long count = gcd(A, B);
		
		for (int i = 0; i < count; i++) {
			sb.append("1");
		}
		System.out.print(sb);
	}
	
	static long gcd (long A, long B) {
		if (B == 0) return A;
		return gcd(B, A % B);
	}
}
