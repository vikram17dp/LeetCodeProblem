class Solution { // tc is o(n) and sc is o(1)
public:
    string largestOddNumber(string num) {
        for(int i = num.size()-1;i>=0;i--){
            if(num[i] %2 != 0){
                return num.substr(0,i+1);
            }
            
        }
        return "";
    }
};