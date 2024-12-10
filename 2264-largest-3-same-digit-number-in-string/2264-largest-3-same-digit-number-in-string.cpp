class Solution { // tc is O(n) and sc is O(1)
public:
    string largestGoodInteger(string num) {
         char ans = -1;
        for(int i = 2;i<num.size();i++){
            if(num[i]== num[i-1] && num[i]== num[i-2]){
                ans= max(ans,num[i]);
            }
        }
        return (ans == -1) ? "" : string(3,ans);
    }
};