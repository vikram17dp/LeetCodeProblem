class Solution {
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitions = new ArrayList<>();
        // iterate through the allchar
        for(int i = 0 ;i<str.length();){
            // getting the start  and end index of the list
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(startIndex));
            
            // lop through the start and end index of the list
            for(int s = startIndex +1;s<= endIndex - 1;s++){
                // we have to iterate through the last inedx of the same char
                int lastIndexnextChar = str.lastIndexOf(str.charAt(s));
                
                if(lastIndexnextChar>endIndex){
                    endIndex = lastIndexnextChar;
                }
            }
            partitions.add(endIndex - startIndex +1);
            i = endIndex +1;
        }
        return partitions;
    }
}