import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        for (int value : diffs) {
            right = Math.max(right, value);
        }
        
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (checkComplete(diffs, times, mid, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean checkComplete(int[] diffs, int[] times, int level, long limit) {
        long sum = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                sum += (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                sum += times[i];
            }
            
            if (sum > limit) return false;
        }
        
        return sum <= limit;
    }
}