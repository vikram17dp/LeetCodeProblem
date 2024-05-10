public class Solution {
    public boolean isPalindrome(int x) {
        // Convert integer to string
        String strX = String.valueOf(x);
        // Compare the string with its reverse
        return strX.equals(new StringBuilder(strX).reverse().toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome(121)); // Output: true
        System.out.println(solution.isPalindrome(-121)); // Output: false
        System.out.println(solution.isPalindrome(10)); // Output: false
    }
}
