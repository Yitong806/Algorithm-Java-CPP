package leetcode.contest.biweek69;

public class Leet2129 {
    public String capitalizeTitle(String title) {
        StringBuilder result = new StringBuilder();
        String[] split = title.split(" ");
        for (String s: split){
            if(s.length() == 1 || s.length() == 2){
                result.append(s.toLowerCase()).append(" ");
            }else {
                result.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }
}
