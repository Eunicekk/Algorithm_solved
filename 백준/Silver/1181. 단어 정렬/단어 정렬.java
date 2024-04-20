import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

// 단어 정렬
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<String>(set);
		
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
