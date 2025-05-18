import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lost_list = new ArrayList<>();
        List<Integer> reserve_list = new ArrayList<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int l : lost) {
            boolean overlap = false;
            
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == l) {
                    reserve[i] = -1;
                    overlap = true;
                    break;
                }
            }
            
            if (!overlap) {
                lost_list.add(l);
            }
        }
        
        for (int r : reserve) {
            if (r != -1) reserve_list.add(r);
        }
        
        for (int r : reserve_list) {
            for (int i = 0; i < lost_list.size(); i++) {
                int l = lost_list.get(i);
                if (Math.abs(l - r) == 1) {
                    lost_list.remove(i);
                    break;
                }
            }
        }

        return n - lost_list.size();
    }
}