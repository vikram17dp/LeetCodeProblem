class Solution { // Tc is O(n! * N) and Sc is o(N) where the n is the stack space of the list
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    
    private void backtrack (List<List<Integer>> resultList,ArrayList<Integer> tempList,int[] nums){
        // if we match the length then we got the permutation
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int number : nums){
            // skip if we get the same element
            if(tempList.contains(number))
                continue;
            
            // add the number
            tempList.add(number);
            
            // backtrack again to checkthe other numbers
            
            backtrack(resultList,tempList,nums);
            
            // remove the number from the list
            
            tempList.remove(tempList.size()-1);
        }
    }
}