class Solution {
    public int bulbSwitch(int n) {
        int i=1;
        int count =0;
        // in an interview they are asking the logic in this question
        // for every even numbers= bulb is OFF ans odd numbers = bulb is ON
        while(i*i <=n){
            count++;
            i++;

        }
        return count;
    }
}