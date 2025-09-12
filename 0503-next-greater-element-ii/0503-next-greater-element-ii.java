class Solution { // tc is O(4N) and sc is O(3N)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        // Map<Integer,Integer> map = new HashMap<>();
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        

        for(int i = 0;i< 2 *n;i++){
            int index = i % n;

            while(!st.isEmpty() && nums[st.peek()] < nums[index]){
                // map.put(nums[st.pop()],nums[index]);
                result[st.pop()] = nums[index];
            }
            if(i<n){
                st.push(index);
            } 
        }
        // for(int i = 0;i<n;i++){
        //    result[i]= map.getOrDefault(nums[i],-1);
        // }
        return result;
    }
}