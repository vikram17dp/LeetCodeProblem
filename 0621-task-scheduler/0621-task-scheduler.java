class Solution { // tc is O(N + 26 log 26) and sc is O(26)
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        //step1:Count frequencies
        for(int i = 0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        // step2:Calculate initial idle slots
        int maxFreq = count[25];
        int idle = (maxFreq-1) * n;
        // step 3:Subtract using other tasks
        for(int i = 24;i>=0;i--){
            idle -= Math.min(maxFreq-1,count[i]);
        }
        idle = Math.max(0,idle);
        // Avoid negative idles & it will help for second test cases
        return tasks.length + idle;
    }
}