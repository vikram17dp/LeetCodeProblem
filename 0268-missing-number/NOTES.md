better solution and TC is 2O(N) and SC is O(N)
class Solution {
public int missingNumber(int[] nums) {
HashSet<Integer> hash = new HashSet<>();
int n = nums.length;
for(int num : nums){
hash.add(num);
}
for(int i = 1;i<n;i++){
if(!hash.contains(i)){
return i;
}
}
return -1;
}
}