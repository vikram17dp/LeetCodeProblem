class Solution { // tc is O(nlogn) and sc is O(n)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Base case: if total cards can't be divided evenly into groups
        if (hand.length % groupSize != 0) return false;

        // Step 1: Count frequency of each card using TreeMap (sorted keys)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Step 2: Try forming groups starting from the smallest card
        while (!map.isEmpty()) {
            int first = map.firstKey(); // smallest card available

            // Try to form a group starting from 'first' to 'first + groupSize - 1'
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;

                // If the card is not present, return false
                if (!map.containsKey(card)) return false;

                // Use one card (decrease its count)
                map.put(card, map.get(card) - 1);

                // If count becomes 0, remove it from map
                if (map.get(card) == 0) map.remove(card);
            }
        }

        // All groups formed successfully
        return true;
    }
}
