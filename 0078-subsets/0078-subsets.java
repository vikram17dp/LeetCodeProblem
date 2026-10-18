class Solution { // tc is O(n.2^n) and sc is O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0,nums,new ArrayList<>(),result);
        return result;
    }

    private static void generateSubsets(int index,int[] nums,List<Integer> current,List<List<Integer>> result){
        // base case
         result.add(new ArrayList<>(current));
        // run an loop over the elements

        for(int i= index;i<nums.length;i++){
            current.add(nums[i]);
            generateSubsets(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
    }
}