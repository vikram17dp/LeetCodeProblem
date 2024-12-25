class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
         // storing the freq of numbers
         int count[102] = {0};
        
        for(int num:nums){
            count[num]++;
        }
        
        int totalCount = 0;
        
        for(int i:count){
            totalCount += ((i) * (i-1)/2);
            // ((i) * (i-1)/2) this will give the nc2 = n!/r! * (n-r)!;
        }
        return totalCount;
        
        
    }
};