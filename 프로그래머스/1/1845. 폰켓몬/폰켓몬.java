import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 2;
        int count = 0;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            count++;
            
            if (length == count) break;
        }
        
        return count;
    }
}