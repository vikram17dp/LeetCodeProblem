class Solution {// tc is o(logn) and sc is o(1)
    public int divide(int dividend, int divisor) {
        // edge case:
        if(dividend == Integer.MIN_VALUE && divisor  == -1){
            return Integer.MAX_VALUE;
        }

        // sign for the negative 
        boolean negative = (dividend < 0 ) ^ (divisor < 0);

         // Convert both to long and take absolute value
         long dvd = Math.abs((long) dividend);
         long dvs = Math.abs((long) divisor);
         int result =0;
         while(dvd >= dvs){
            long temp = dvs;
            int multiple = 1;
             // Find the biggest multiple (temp << 1 ≤ dvd)
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract and accumulate result
            dvd -= temp;
            result += multiple;
         }
         return negative ? - result : result;
}}