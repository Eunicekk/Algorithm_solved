import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수&팰린드롬
public class Main {
	
	static boolean prime[] = new boolean[1004002];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prime();
		
		for (int i = N; i < 1004000; i++) {
			if (!prime[i]) {
				String str = String.valueOf(i);
				StringBuffer sb = new StringBuffer(str);
				String reverse = sb.reverse().toString();
				
				if (str.equals(reverse)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	static void prime () {
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) continue;
			
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
	
}
