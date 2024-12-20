class Solution { // tc is O(nsquare) and sc is O(1)
public int numberOfSubarrays(int[] nums, int k) {
int n = nums.length;
int count = 0;
for(int i = 0;i<n;i++){
int odd = 0;
for(int j = i;j<n;j++){
if(nums[j] % 2  != 0 ){
odd++;
}
if(odd == k){
count++;
}
}
}
return count;
}
}