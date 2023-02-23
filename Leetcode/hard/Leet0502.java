package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leet0502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.profit, p1.profit));

        for (int i = 0; i < profits.length; i++) {
            pq.offer(new Project(profits[i], capital[i]));
        }

        while (k > 0){
            boolean findOK = false;
            List<Project> tempStorage = new ArrayList<>();
            while (!pq.isEmpty()){
                Project pop = pq.poll();
                if(pop.capital > w){
                    tempStorage.add(pop);
                }else {
                    findOK = true;
                    k -= 1;
                    w += pop.getProfit();
                    break;
                }
            }

            if(!findOK){
                break;
            }

            pq.addAll(tempStorage);
        }

        return w;
    }

    private static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        public int getProfit(){
            return profit;
        }
    }
}
