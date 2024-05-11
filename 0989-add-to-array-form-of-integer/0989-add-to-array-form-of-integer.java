class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>();
      
        int carry = 0;
        int p = num.length-1;
        while(p>=0 || k>0) {
            int numVal = 0;
             if(p>=0){
                numVal=num[p];
             }
             int d = k%10;// last digit from the number
             int sum=numVal + d + carry;
             int digit = sum%10; // if the number is 2 or 3 digit number then it will %10 that number
             carry = sum/10;
             list.add(digit);
             p--; // moving pointer
             k = k/10;
             
            
            
        }
        if(carry>0){
            list.add(carry); // adding the carry to the list
        }
        Collections.reverse(list);// reversing the order of the ArrayList
        return list;
        
    }
}