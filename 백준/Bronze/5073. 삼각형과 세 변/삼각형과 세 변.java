import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 삼각형과 세 변
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] triangle = new int[3];
			int max = Integer.MIN_VALUE;
			int index = -1;
			int sum = 0;
			
			for (int i = 0; i < 3; i++) {
				triangle[i] = Integer.parseInt(st.nextToken());
				sum += triangle[i];
				if (max < triangle[i]) {
					max = triangle[i];
					index = i;
				}
			}
			
			if (sum == 0) {
				break;
			}
			
			if (triangle[index] >= sum - triangle[index]) {
				bw.write("Invalid\n");
			} else if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
				bw.write("Equilateral\n");
			} else if (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) {
				bw.write("Isosceles\n");
			} else {
				bw.write("Scalene\n");
			}
		}
		
		bw.close();
	}
	
}