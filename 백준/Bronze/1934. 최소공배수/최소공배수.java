import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 최소공배수
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			List<Integer> nums = new ArrayList<Integer>();
			int index = 2;
			
			while (true) {
				if (index > A || index > B) {
					break;
				}
				
				while (true) {
					if (A % index == 0 && B % index == 0) {
						A /= index;
						B /= index;
						nums.add(index);
					} else {
						break;
					}
				}
				
				index++;
			}
			
			int answer = A * B;
			
			for (int i = 0; i < nums.size(); i++) {
				answer *= nums.get(i);
			}
			
			bw.write(answer + "\n");
		} // tc
		
		bw.close();
	} // main
	
}