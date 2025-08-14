class Solution {// two pointer approach left and right and tc is O(nsqaure) and sc is O(1) or O(n)
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();

       int n = nums.length;

       // sort
       Arrays.sort(nums);// tc is O(nlogn)

       for(int i = 0;i<n-2;i++){// tc is O(n)
            if(i > 0 && nums[i] == nums[i-1]) continue;// for the duplicates elements
            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){// tc is O(n)
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                // skip the duplicates from left values
                while(left < right && nums[left] == nums[left + 1]) left++;

                // skip the duplicates from right values
                while(left < right && nums[right] == nums[right -1]) right--;
                // if both the left and right next values are not equal means
                left++;
                right--;
                }
            
            else if(sum < 0){
                left++;
            }else{
                right--;
            }
            }
       }
       return result;
    }
   
    
}