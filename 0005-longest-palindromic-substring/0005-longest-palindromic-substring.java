class Solution {

    public String longestPalindrome(String s) {
        int sLen = s.length();
        int[][] dp = new int[sLen][sLen];
        int maxSize = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = 1;
            maxSize = 1;
            maxStart = i;
            maxEnd = i;
        }
        for(int i = 0; i < sLen - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = 1;
                maxSize = 2;
                maxStart = i;
                maxEnd = i + 1;
            }
        }

        for (int i = 3; i <= sLen; i++) {
            for (int j = 0; j <= sLen - i; j++) {
                int startIndex = j;
                int endIndex = j + i - 1;
                if(s.charAt(startIndex) == s.charAt(endIndex) && dp[startIndex + 1][endIndex - 1] > 0) {
                    dp[startIndex][endIndex] = 1;
                    maxSize = i;
                    maxStart = startIndex;
                    maxEnd = endIndex;
                }
            }             
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
}
