public class Leet1556 {
    public String thousandSeparator(int n) {
        StringBuilder b = new StringBuilder();

        String s = Integer.toString(n);
        for (int index = s.length() - 1; index >= 0; index -= 3){
            if(index >= 3){
                b.append(s.charAt(index)).append(s.charAt(index - 1)).append(s.charAt(index - 2)).append(".");
            }else {
                for (int j = index; j >= 0;j --){
                    b.append(s.charAt(j));
                }
            }
        }

        return b.reverse().toString();
    }
}
