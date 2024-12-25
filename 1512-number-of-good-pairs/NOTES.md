class Solution { // tc is O(nsqaure) and sc is O(1)
public int numIdenticalPairs(int[] nums) {
int n = nums.length;
int goodPair = 0;
for(int i = 0;i<n;i++){
for(int j = i+1;j<n;j++){
if(nums[i] == nums[j]){
goodPair+=1;
}
}
}
return goodPair;
}
}