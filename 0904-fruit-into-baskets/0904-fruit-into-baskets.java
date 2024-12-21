class Solution { // tc is O(2N) and sc is O(3)
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxlength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int right = 0,left = 0;
        
        while(right < n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
            right++;
        }
        
        return maxlength;
    }
}