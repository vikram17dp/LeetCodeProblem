class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) { // TC is O(N!) and sc is o(n.n!)
        List<List<Integer>> resultList = new ArrayList<>();
        
        Arrays.sort(nums);
        backtrack(resultList,new ArrayList<>(),nums,new boolean[nums.length]);
        return resultList;
    }
    private void backtrack( List<List<Integer>> resultList, ArrayList<Integer> tempList,int[] nums,boolean[] used){
        // when we got the element
        if(tempList.size() == nums.length && !resultList.contains(tempList)){
             resultList.add(new ArrayList<>(tempList));
             return;
        }
        for(int i = 0;i<nums.length;i++){
            // skip we got the same element
            // if(used[i]) continue;
            // this line give the better filter for the duplicates finding compare to the above one
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
            
            
            // if we got the new element and mark into the true
            used[i] = true;
            tempList.add(nums[i]);
            
            // backtrack again to check the other numbers
            backtrack(resultList,tempList,nums,used);
            
            // remove the element and marked it into the false
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
        
        
    }
}