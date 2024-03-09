import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 가로수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Long> tree = new ArrayList<Long>();
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			tree.add(Long.parseLong(br.readLine()));
		}
		
		long num = gcd(tree.get(1) - tree.get(0), tree.get(2) - tree.get(1));
		
		for (int i = 2; i < N-1; i++) {
			num = gcd(num, tree.get(i+1) - tree.get(i));
			
			if (num == 1 || num == 2) {
				break;
			}
		}
		
		for (int i = 0; i < N - 1; i++) {
			answer += (tree.get(i+1) - tree.get(i)) / num - 1; 
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
	// 최대공약수 (유클리드 호제법)
	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		
		 return a;
	}
	
}