class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] matrix = new int[text1.length()][text2.length()];
        int maxLen = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int curr = 0;
                int prev = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr = 1;
                    if (i > 0 && j > 0) {
                        prev = matrix[i - 1][j - 1];
                    }
                } else {
                    if (i == 0 && j > 0) {
                        prev = matrix[i][j - 1];
                    } else if (j == 0 && i > 0) {
                        prev = matrix[i - 1][j];
                    } else if (i > 0 && j > 0) {
                        prev = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                    }
                }
                matrix[i][j] = prev + curr;
                if (matrix[i][j] > maxLen) {
                    maxLen = matrix[i][j];
                }
            }
        }

        return maxLen;
    }
}
