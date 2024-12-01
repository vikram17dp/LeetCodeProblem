class Solution { // TC is O(N) and SC is O(26)
public:
    int partitionString(string s) {
        unordered_set<char>st;
        int count = 1;
        for(int i = 0;i<s.size();i++){
            if(st.find(s[i])!=st.end()){
                count++;
                st.clear();
            }
            st.insert(s[i]);
        }
        return count;
    }
};