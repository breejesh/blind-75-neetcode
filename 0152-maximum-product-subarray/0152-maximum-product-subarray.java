class Solution {

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int prevMax = 1;
        int prevMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, 0);
                prevMax = 1;
                prevMin = 1;
            } else {
                int tempPrevMax = prevMax;
                prevMax = Math.max(Math.max(prevMax * nums[i], prevMin * nums[i]), nums[i]);
                prevMin = Math.min(Math.min(tempPrevMax * nums[i], prevMin * nums[i]), nums[i]);
                res = Math.max(res, prevMax);
            }
        }
        return res;
    }
}
