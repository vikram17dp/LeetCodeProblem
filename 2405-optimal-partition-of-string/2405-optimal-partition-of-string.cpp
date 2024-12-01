class Solution { 
public:
    int partitionString(string s) { // TC is O(N) and SC is O(26) using the hashset
        // unordered_set<char>st;
        // int count = 1;
        // for(int i = 0;i<s.size();i++){
        //     if(st.find(s[i])!=st.end()){
        //         count++;
        //         st.clear();
        //     }
        //     st.insert(s[i]);
        // }
        // return count;
        
        // using the arrays with same tc and sc but it is faster compare to the hashset
        
        int partitioncount = 0;
        int charCount[26]={0};
        
        for(char c:s){
            if(charCount[c-'a']>0){
                partitioncount++;
                fill(begin(charCount), end(charCount), 0);
            }
            charCount[c-'a']++;
            
        }
        return partitioncount +1;
        
    }
};