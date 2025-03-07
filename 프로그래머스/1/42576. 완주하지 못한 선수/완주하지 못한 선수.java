import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for (String comp : completion) {
            map.replace(comp, map.get(comp) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        
        return "";
    }
}