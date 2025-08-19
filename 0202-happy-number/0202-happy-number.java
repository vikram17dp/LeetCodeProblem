class Solution { // tc is O(logn) and sc is O(1)
    public boolean isHappy(int n) {// fast and slow pointers when they are equal to 1 then it is an happy number
        int slow = n;
        int fast = n;

        do{
            slow = sumOfSqaures(slow);// one step
            fast = sumOfSqaures(sumOfSqaures(fast));// two step
        }while(slow != fast);
        
        return slow == 1;// they both are met at 1 -> happy number
    }
    private int sumOfSqaures(int n){
        int sum = 0;
        while(n>0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}