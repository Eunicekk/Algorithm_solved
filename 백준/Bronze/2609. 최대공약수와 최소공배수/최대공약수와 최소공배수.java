import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd(A, B));
		System.out.println(lcm(A, B));
	}
	
	// 최대공약수
	static int gcd(int a, int b) {
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
	
	// 최소공배수
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
}
