import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 소인수분해 간단하게 풀어보기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int i = 2;
		
		while (N != 1) {
			if (N % i == 0) {
				N /= i;
				bw.write(i + "\n");
			} else {
				i++;
			}
		}
		
		bw.close();
	}
	
}