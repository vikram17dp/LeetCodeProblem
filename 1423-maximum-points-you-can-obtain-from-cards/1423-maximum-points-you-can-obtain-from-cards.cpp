class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
          int n = cardPoints.size();
        
        int lSum = 0,rSum = 0,maxScore = 0;
        
        for(int i = 0;i<k;i++){
            lSum = lSum + cardPoints[i];
        }
        
        maxScore = lSum;
        
        int  rIdx = n-1; // at the end
        
        for(int i = 0;i<k;i++){
            lSum = lSum - cardPoints[k - i-1];
            rSum = rSum + cardPoints[rIdx];
            rIdx = rIdx - 1;
            maxScore = max(maxScore,lSum+rSum);
        }
       return maxScore;
    }
};