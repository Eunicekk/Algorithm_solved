import java.util.*;

class Solution {
    static class Stage {
        int index;
        double fail;
        
        public Stage(int index, double fail) {
            this.index = index;
            this.fail = fail;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] failure = new int[N+1];
        int[] arrival = new int[N+1];
        
        for (int stage : stages) {
            if (stage > N) {
                for (int i = 1; i <= N; i++) {
                    arrival[i] += 1;
                }
                
                continue;
            }
            
            failure[stage] += 1;
            
            for (int i = 1; i <= stage; i++) {
                arrival[i] += 1;
            }
        }
        
        List<Stage> list = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            double failRate = arrival[i] == 0 ? 0 : (double) failure[i] / arrival[i];
            list.add(new Stage(i, failRate));
        }
        
        list.sort(new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                return Double.compare(o2.fail, o1.fail);
            }
        });
        
        int[] result = new int[N];
        
        for (int i = 0; i < N; i++) {
            result[i] = list.get(i).index;
        }
        
        return result;
    }
}