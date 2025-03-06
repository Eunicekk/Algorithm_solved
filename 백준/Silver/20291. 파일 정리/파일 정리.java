import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String type = br.readLine().split("\\.")[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		list.sort((a, b) -> {
			return a.getKey().compareTo(b.getKey());
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
		}
	}
	
}
