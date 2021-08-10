package syz;

import java.math.BigInteger;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger big = new BigInteger("1");
        BigInteger biggg = new BigInteger("0");
        long sum = 1, all = 0;
        for (int i = 1; i <= n; i++) {
            big = big.multiply(new BigInteger(i + ""));
            biggg = biggg.add(big);
        }
        System.out.println(biggg.toString());
    }
}
