class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList();
        dfs(candidates, target, 0, new ArrayList(), 0, result);
        return result;
    }
    
    public void dfs(int[] candidates, int target, int currentIndex, List<Integer> currentList, int currentSum, List<List<Integer>> result) {
        if(currentSum > target) {
            return;
        }
        if(currentSum == target) {
            result.add(new ArrayList(currentList));
            return;
        }
        
        for(int i = currentIndex; i < candidates.length; i++) {
            if(currentSum + candidates[i] <= target) {
                currentList.add(candidates[i]);
                currentSum += candidates[i];
                dfs(candidates, target, i, currentList, currentSum, result);
                currentSum -= candidates[i];
                currentList.remove(currentList.size() - 1);
            }
            
        }
    }
}