public class Leet1716 {
    public int totalMoney(int n) {
        int first = (1 + 2 + 3 + 4 + 5 + 6 + 7) * (n / 7) + 7 * (n / 7) * (n / 7 - 1) / 2;

        int second = (n / 7 + 1) * (n % 7) + (n % 7) * (n % 7 - 1) / 2;

        return first + second;
    }
}
