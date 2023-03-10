package leetcode.medium;

public class Leet0012 {
    public String intToRoman(int num) {
        int thousand = num / 1000;
        int hundred = num % 1000 / 100;
        int ten = num % 100 / 10;
        int one = num % 10;

        StringBuilder b = new StringBuilder();
        form(b, thousand, "", "", "","M");
        form(b, hundred, "CM", "CD", "D", "C");
        form(b, ten, "XC", "XL","L","X");
        form(b, one, "IX","IV","V","I");
        return b.toString();
    }

    public void form(StringBuilder b, int number, String str9, String str4,
                     String str5, String str1) {
        if (number == 9) {
            b.append(str9);
        } else if (number == 4) {
            b.append(str4);
        } else {
            int number5 = number / 5, numberRest = number % 5;
            for (int i = 0; i < number5; i++) {
                b.append(str5);
            }

            for (int i = 0; i < numberRest; i++) {
                b.append(str1);
            }
        }
    }

    public static void main(String[] args) {
        Leet0012 lc = new Leet0012();
        System.out.println(lc.intToRoman(1994));
    }
}
