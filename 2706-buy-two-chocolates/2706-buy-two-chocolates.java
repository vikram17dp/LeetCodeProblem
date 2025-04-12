public class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Find the two smallest prices
        for (int price : prices) {
            if (price < min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }

        int total = min1 + min2;

        // If we can afford both, return the leftover
        if (total <= money) {
            return money - total;
        }

        // Otherwise, we can't buy two chocolates
        return money;
    }
}
