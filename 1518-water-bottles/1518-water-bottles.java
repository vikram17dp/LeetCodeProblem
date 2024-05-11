class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // taken 2nd example and dry run the code
        int ans = numBottles; //15
        while(numBottles>=numExchange){ // 15>=4
            int newBottles = numBottles / numExchange; // => 3
            int remBottles = numBottles % numExchange; // =>3
            ans = ans + newBottles; // => 15 + 3
            numBottles = newBottles + remBottles; // 3 + 3 = 6 and finaly it will move on to the ans = numbootle and again loop will work.
        }
        return ans;
    }
}