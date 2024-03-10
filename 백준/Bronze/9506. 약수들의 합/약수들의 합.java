import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 약수들의 합
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			List<Integer> list = new ArrayList<>();
			int num = Integer.parseInt(br.readLine());
			int sum = 0;
			
			if (num == -1) {
				break;
			}

			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					list.add(i);
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
			
			if (num == sum) {
				bw.write(num + " = " + list.get(0));
				for (int i : list) {
					if (i == list.get(0)) {
						continue;
					}
					
					bw.write(" + " + i);
				}
				bw.write("\n");
			} else {
				bw.write(num + " is NOT perfect.\n");
			}
		}
		
		bw.close();
	}
	
}