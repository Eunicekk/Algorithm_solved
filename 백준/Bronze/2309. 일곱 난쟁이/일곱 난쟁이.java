import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 일곱 난쟁이
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer> height = new ArrayList<Integer>();
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			height.add(Integer.parseInt(br.readLine()));
			sum += height.get(i);
		}
		
		Collections.sort(height);
		
		out : for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sum - height.get(i) - height.get(j) == 100) {
					if (height.get(i) < height.get(j)) {
						height.remove(j);
						height.remove(i);
					} else {
						height.remove(i);
						height.remove(j);
					}
					
					break out;
				}
			}
		}
		
		for (int i = 0; i < 7; i++) {
			bw.write(height.get(i) + "\n");
		}
		
		bw.close();
	}
	
}
