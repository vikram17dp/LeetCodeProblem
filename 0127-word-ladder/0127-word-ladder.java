class Solution { // tc is O(N * L * 26)and sc is o(N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0;k<size;k++){
                String word = queue.poll();

                if(word.equals(endWord)){
                    return steps;
                }
                char[] arr = word.toCharArray();
                for(int i = 0;i<arr.length;i++){
                    char originalChar = arr[i];

                    for(char ch = 'a';ch<='z';ch++){
                        if(ch == originalChar) continue;
                        arr[i] = ch;
                        String newWord = new String(arr);

                        if(wordSet.contains(newWord)){
                             queue.offer(newWord);
                            wordSet.remove(newWord); // remove to avoid revisiting
                        }
                    }
                    arr[i] = originalChar;
                }
            }
            steps++;
        }
        return 0;

    }
}