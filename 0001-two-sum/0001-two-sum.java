class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(target - nums[i]) && i != numMap.get(target - nums[i])) {
                return new int[] {i, numMap.get(target -  nums[i])};
            }
        }
        return new int[] {-1, -1};        
    }
}