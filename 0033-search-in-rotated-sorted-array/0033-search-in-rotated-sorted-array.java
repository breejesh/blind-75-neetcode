class Solution {

    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int mid = (rightIndex + leftIndex) / 2;
        System.out.println(mid);
        while (leftIndex < rightIndex) {
            if (nums[mid] == target) {
                return mid;
            } else if(nums[leftIndex] == target) {
                return leftIndex;
            } else if(nums[rightIndex] == target) {
                return rightIndex;
            } else if ((nums[mid] < target && (nums[rightIndex] > target || nums[rightIndex] < nums[mid]))                   
                       || (nums[mid] > target && nums[mid] > nums[rightIndex] && nums[rightIndex] > target)) {
                leftIndex = mid + 1;
            } else {
                rightIndex = mid - 1;
            }
            mid = (rightIndex + leftIndex) / 2;
        }
        if (nums[mid] == target) {
            return mid;
        }
        return -1;
    }
}
