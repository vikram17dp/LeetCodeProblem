class Solution {
public:
    int numberOfSubstrings(string s) {
        int count = 0,left =0, n = s.size();
        int charCount[3] ={0};
    
        for(int right = 0;right<n;right++){
            
         charCount[s[right]-'a']++;
            
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] >0){
                count += n-right;
                // shrking the window size
                charCount[s[left] - 'a']--;
                left++;
            }    
        }
        return count;
    }
};