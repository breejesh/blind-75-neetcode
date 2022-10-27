class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int maxSeq = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        dp[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            maxSeq = Math.max(maxSeq, dfs(nums, i, nums[i], dp) + 1);
        }
        return maxSeq;
    }

    private int dfs(int[] nums, int currentIndex, int element, int[] dp) {
        if (currentIndex >= nums.length) {
            return 0;
        }
        if (currentIndex == nums.length - 1) {
            if (element < nums[currentIndex]) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }
        int maxSeqLen = 0;
        if (element < nums[currentIndex + 1]) {
            maxSeqLen = Math.max(maxSeqLen, dfs(nums, currentIndex + 1, nums[currentIndex + 1], dp) + 1);
        }
        int tempIndex = currentIndex + 2;
        while (tempIndex < nums.length) {
            if (nums[tempIndex] > element) {
                maxSeqLen = Math.max(maxSeqLen, dfs(nums, tempIndex, nums[tempIndex], dp) + 1);
            }
            tempIndex++;
        }
        dp[currentIndex] = maxSeqLen;
        return maxSeqLen;
    }
}
