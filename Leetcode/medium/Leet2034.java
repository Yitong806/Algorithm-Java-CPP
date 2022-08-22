import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet2034 {
    private static class StockPrice {

        int maximumTime = -1;
        Map<Integer, Integer> timeStampPriceMapping = new HashMap<>();
        PriorityQueue<Record> maximumPricePQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.price, o2.price) * -1);
        PriorityQueue<Record> minimumPricePQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.price));

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            timeStampPriceMapping.put(timestamp, price);
            maximumPricePQ.offer(new Record(timestamp, price));
            minimumPricePQ.offer(new Record(timestamp, price));
            maximumTime = Math.max(timestamp, maximumTime);

        }

        public int current() {
            return timeStampPriceMapping.get(maximumTime);
        }

        public int maximum() {
            Record peek = maximumPricePQ.peek();

            while (!maximumPricePQ.isEmpty()){
                peek = maximumPricePQ.peek();
                if (timeStampPriceMapping.get(peek.timeStamp) != peek.price){
                    maximumPricePQ.poll();
                }
            }

            return peek.price;

        }

        public int minimum() {
            Record peek = minimumPricePQ.peek();

            while (!minimumPricePQ.isEmpty()){
                peek = minimumPricePQ.peek();
                if (timeStampPriceMapping.get(peek.timeStamp) != peek.price){
                    minimumPricePQ.poll();
                }
            }

            return peek.price;

        }

        private static class Record{
            int timeStamp;
            int price;

            public Record(int timeStamp, int price) {
                this.timeStamp = timeStamp;
                this.price = price;
            }
        }
    }
}
