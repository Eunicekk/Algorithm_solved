import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 분수 합
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int A2 = Integer.parseInt(st2.nextToken());
		int B2 = Integer.parseInt(st2.nextToken());
		
		int A = A1 * B2 + B1 * A2;
		int B = B1 * B2;
		
		int min = Math.min(A, B);
		int i = 2;
		
		while (true) {
			if (A % i == 0 && B % i == 0) {
				A /= i;
				B /= i;
			} else {
				i++;
			}
			
			if (i > min) {
				break;
			}
		}
		
		bw.write(A + " " + B);
		bw.close();
	}
	
}