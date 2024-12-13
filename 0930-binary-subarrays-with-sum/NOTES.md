class Solution {
public int numSubarraysWithSum(int[] nums, int goal) {
int l = 0, r = 0, sum =0,count =0;
int m = nums.length;
while(r<m){
sum += nums[r];
// sliding shrinking
while( l<=r && sum>goal){
sum -= nums[l];
l = l+1;
}
if(sum == goal){
int temp = l;
while (temp <= r && nums[temp] == 0) {
count++;
temp++;
}
count++;
}
r = r+1;
}
return count;
}
} brute force