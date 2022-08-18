public class Leet2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, rest = capacity;
        int nextWatered = 0;
        do {
            if (plants[nextWatered] <= rest) {
                rest -= plants[nextWatered];
                nextWatered++;
                steps += 1;
            } else {
                rest = capacity;
                steps += 2 * nextWatered;
            }

        } while (nextWatered != plants.length);

        return steps;
    }

}
