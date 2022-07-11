import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<StudentClass> maxHeap = new PriorityQueue<>((o1, o2) -> Double.compare(o2.deltaValue(), o1.deltaValue()));

        for (int[] cl : classes){
            maxHeap.offer(new StudentClass(cl[0], cl[1]));
        }

        while (extraStudents -- > 0 && !maxHeap.isEmpty()){
            StudentClass pop = maxHeap.poll();
            pop.delta();
            maxHeap.offer(pop);
        }

        double sum = 0;

        for(StudentClass s: maxHeap){
            sum += s.value();
        }

        return sum / classes.length;
    }

    private static class StudentClass {
        int pass;
        int total;

        public StudentClass(int p, int t){
            pass = p;
            total = t;
        }

        public void delta(){
            pass += 1;
            total += 1;
        }

        public double value(){
            return pass * 1.0 / total;
        }

        public double deltaValue(){
            return (pass + 1) * 1.0 / (total + 1) - pass * 1.0 / total;
        }
    }
}
