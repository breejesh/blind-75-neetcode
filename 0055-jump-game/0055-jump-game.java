class Solution {

    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) return false;
        if (nums[0] == 0 && nums.length == 1) return true;
        int zeroLength = 0;
        int maxJumpAtCurrentIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroLength++;
            } else {
                if (zeroLength > 0) {
                    if (maxJumpAtCurrentIndex == 0) {
                        return false;
                    }
                }
                if (nums[i] + 1 > maxJumpAtCurrentIndex) {
                    maxJumpAtCurrentIndex = nums[i] + 1;
                }

                zeroLength = 0;
            }
            maxJumpAtCurrentIndex--;
            if (maxJumpAtCurrentIndex < 0) {
                maxJumpAtCurrentIndex = 0;
            }
        }
        if (zeroLength > 0) {
            if (maxJumpAtCurrentIndex == 0) {
                return false;
            }
        }
        return true;
    }
}
