import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 분해합
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int n = 0; n < N; n++) {
			String num = String.format("%d", n);
			int sum = 0;
			
			for (int i = 0; i < num.length(); i++) {
				sum += num.charAt(i) - '0';
			}
			
			if (N - n == sum) {
				answer = n;
				break;
			}
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
}