class Solution { // tc is O(t.2^n) and sc is O(t + 2^n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationSum(0,candidates,target,result,new ArrayList<>());
        return result;
    }

    public static void findCombinationSum(int index,int[] arr,int target,List<List<Integer>> result,List<Integer> ds){
            if(index == arr.length){
                if(target == 0){
                    result.add(new ArrayList<>(ds));
                }
                return;
            }
            if(arr[index] <= target){
                ds.add(arr[index]);
                findCombinationSum(index,arr,target-arr[index],result,ds);
                ds.remove(ds.size()-1);
            }
            findCombinationSum(index+1,arr,target,result,ds);
    }
}