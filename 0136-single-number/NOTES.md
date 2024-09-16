// BRUTE FORCE USING LINEAR SEARCH
class Solution {
public int singleNumber(int[] nums) {
int n = nums.length;
int count = 0;
for(int i =0;i<n;i++){
int num = nums[i];
count = 0;
for(int j =0;j<n;j++){
if(nums[j] == num){
count++;
}
}
if(count == 1) return num;
}
throw new IllegalArgumentException("No single number found");
}
// better solution using hashmap
class Solution {
public int singleNumber(int[] nums) {
int n = nums.length;
HashMap<Integer,Integer> hash = new HashMap<>();
for(int num:nums){
hash.put(num,hash.getOrDefault(num,0)+1);
}
for(int num:hash.keySet()){
if(hash.get(num) == 1){
return num;
}
}
throw new IllegalArgumentException("No single number found");
}
}
// optimal solution is xor methdos
}