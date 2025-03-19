class Solution { // tc is O(2N)=> O(N) and sc is O(n)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid: asteroids){
            boolean destroyed = false;

            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                // left and right values larger and smaller
                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;
                }
                // both are equal astreoids
                else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                 destroyed = true;
                 break;
                
            }
            if(!destroyed){
                stack.push(asteroid);
            }

        }
        int[] result = new int[stack.size()];
        for(int i = result.length-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}