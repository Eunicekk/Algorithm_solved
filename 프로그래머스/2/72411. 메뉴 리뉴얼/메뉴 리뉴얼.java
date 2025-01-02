import java.util.*;

class Solution {
    static List<String> answer = new ArrayList<>();
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = new String(order);
        }
        
        for (int c : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() >= c) combination(order, "", 0, c);
            }
            
            int max = 2;
            for (int count : map.values()) {
                max = Math.max(max, count);
            }
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) answer.add(entry.getKey());
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    void combination(String order, String current, int index, int length) {
        if (current.length() == length) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        if (index >= order.length()) return;
        
        combination(order, current + order.charAt(index), index + 1, length);
        combination(order, current, index + 1, length);
    }
}