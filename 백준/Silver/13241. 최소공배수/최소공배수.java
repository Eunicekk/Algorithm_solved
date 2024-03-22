import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 최소공배수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		
		long max = Math.max(A, B);
		long min = Math.min(A, B);
		long num = 1;
		long index = 2;
		
		while (true) {
			if (index > min) {
				break;
			}
			
			while (true) {
				if (A % index == 0 && B % index == 0) {
					A /= index;
					B /= index;
					num *= index;
				} else {
					break;
				}
			}
			
			index++;
		}
		
		if (max % min == 0) {
			bw.write(max + "");
		} else if (max % min != 0 && max == A) {
			bw.write(max * min + "");
		} else {
			bw.write(num * A * B + "");
		}
		
		bw.close();
	}
	
}