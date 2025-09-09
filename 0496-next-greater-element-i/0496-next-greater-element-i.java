class Solution { // tc is O(N+M) and sc is O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> nextGreater = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            // step1: find the nge for the nums2 and store it in the hashmap


            for(int num:nums2){
                while(!stack.isEmpty()&& num > stack.peek()){
                    nextGreater.put(stack.pop(),num);
                }
                // if stack is empty
                stack.push(num);
            }

            // step2: check in the hashmap using an nums1
            int[] result = new int[nums1.length];
            for(int i = 0;i<nums1.length;i++){
                result[i] = nextGreater.getOrDefault(nums1[i],-1);
            }
            return result;
    }

}