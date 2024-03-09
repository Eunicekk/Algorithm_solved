import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 수 이어가기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> maxs = new ArrayList<Integer>();
		
		for (int n = N; n >= N/2; n--) {
			List<Integer> nums = new ArrayList<Integer>();
			
			nums.add(N);
			nums.add(n);
			int count = 2;
			
			while (true) {
				int num = nums.get(nums.size() - 2) - nums.get(nums.size() - 1);
				
				if (num >= 0) {
					count++;
					nums.add(num);
				} else {
					break;
				}
			}
			
			if (max < count) {
				max = count;
				maxs.clear();
				
				for (int i = 0; i < nums.size(); i++) {
					maxs.add(nums.get(i));
				}
			}
		}
		
		bw.write(max + "\n");
		
		for (int i = 0; i < max; i++) {
			bw.write(maxs.get(i) + " ");
		}
		
		bw.close();
	}
	
}