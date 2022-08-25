public class Leet0005 {
    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean[][] isPalindromicDP = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindromicDP[i][i] = true;
        }

        int maxLength = 1, maxStart = 0;

        for (int length = 2; length <= n; length++) {
            for (int startIndex = 0; startIndex + length < n; startIndex++){
                int endIndex = startIndex + length - 1;

                if(length == 2){
                    isPalindromicDP[startIndex][endIndex] = s.charAt(startIndex) == s.charAt(endIndex);
                }else {
                    isPalindromicDP[startIndex][endIndex] = isPalindromicDP[startIndex + 1][endIndex - 1]
                            &&  s.charAt(startIndex) == s.charAt(endIndex);
                }

                if(isPalindromicDP[startIndex][endIndex]){
                    if(length > maxLength){
                        maxLength = length;
                        maxStart = startIndex;
                    }
                }
            }
        }

        System.out.println(maxLength+" "+maxStart);

        return s.substring(maxStart, maxStart + maxLength);
    }
}
