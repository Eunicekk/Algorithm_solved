import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 3
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
	
		for (int i = N-1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}
