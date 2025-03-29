class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;
        int threshold = n/3;

        for(int i =0;i<n;i++){
            int count = 0;
            for(int j = 0;j<n;j++){
                if(nums[j] == nums[i]){
                    count++;
                }
            }
           
            if(count > threshold && !result.contains(nums[i])){
             result.add(nums[i]);
            }
        }
return result;


    }
}