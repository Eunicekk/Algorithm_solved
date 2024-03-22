import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 세 막대
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] nums = new int[3];
		int max = Integer.MIN_VALUE;
		int index = -1;
		int sum = 0;
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
			
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		
		while (true) {
			if (nums[index] >= sum - nums[index]) {
				sum--;
				nums[index]--;
			} else {
				break;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			answer += nums[i];
		}
		
		bw.write(answer + "");
		bw.close();
	}
	
}