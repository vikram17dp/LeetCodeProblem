class Solution {
    // tc is O(2^N) and sc is  \U0001d442(\U0001d441) (recursion stack) + O(2^N) (storing results)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findcombinationSum2(0,target,candidates,result,new ArrayList<>());
        return result;
    }
    public static void findcombinationSum2(int index,int target,int[] arr,List<List<Integer>> result,List<Integer> ds){
        // base case
        if(target == 0){
            result.add(new ArrayList<>(ds));
            return;
        }
        // run a loop over sorted array

        for(int i = index;i<arr.length;i++){
            // skip duplicates
            if(i > index && arr[i] == arr[i-1]) continue;

            // if target exceeds current element
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findcombinationSum2(i+1,target-arr[i],arr,result,ds);
            ds.remove(ds.size()-1);
        }
    }
}