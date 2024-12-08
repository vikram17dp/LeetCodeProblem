class Solution { // tc is O(n2)
public:
bool containsDuplicate(vector<int>& nums) {
int n = nums.size();
for(int i =0;i<n;i++){
int count = 0;
for(int j = 0;j<n;j++){
if(nums[i] == nums[j]){
count++;
}
}
if(count>1) return true;
}
return false;
}
}; it will not work for the larger test cases