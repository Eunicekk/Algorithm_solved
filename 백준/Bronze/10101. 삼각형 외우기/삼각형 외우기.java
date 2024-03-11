import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 삼각형 외우기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		if (a + b + c != 180) {
			bw.write("Error");
		} else if (a == b && a == c && b == c) {
			bw.write("Equilateral");
		} else if (a == b || a == c || b == c) {
			bw.write("Isosceles");
		} else {
			bw.write("Scalene");
		}
		
		bw.close();
	}
	
}