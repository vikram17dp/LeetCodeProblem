class Solution {
public:
    void reverseString(vector<char>& s) {
        int low = 0,high = s.size()-1;
        
        while(low<high){
            int temp = s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
};