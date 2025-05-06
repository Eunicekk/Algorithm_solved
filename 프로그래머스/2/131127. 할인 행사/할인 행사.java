import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                String item = discount[i + j];
                discountMap.put(item, discountMap.getOrDefault(item, 0) + 1);
            }
            if (isMatch(wantMap, discountMap)) {
                result++;
            }
        }
        
        return result;
    }

    private boolean isMatch(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String key : wantMap.keySet()) {
            if (discountMap.getOrDefault(key, 0) != wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
