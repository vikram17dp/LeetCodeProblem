class Solution {
public int subarraySum(int[] nums, int k) { // O(n2)
int count = 0;
int n = nums.length;
int sum = 0;
for(int i =0;i<n;i++){
sum = 0;
for(int j = i;j<n;j++){
sum+= nums[j];
if(sum == k){
count ++;
}
}
}
return count;
}
}