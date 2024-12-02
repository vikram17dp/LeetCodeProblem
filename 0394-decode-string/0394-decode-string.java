class Solution {
    public String decodeString(String str) { // Tc and Sc is O(n)
        Stack<Integer> countStack = new Stack<>(); // To store repetition counts
        Stack<String> stringStack = new Stack<>(); // To store partial results
        
        String currentString = ""; // intailize with empty string
        int countNumber = 0; // intalize with 0
        
        for(char c:str.toCharArray()){
            if (Character.isDigit(c)) {
                // Build the number (for multi-digit cases)
                countNumber = countNumber * 10 + (c - '0');
            } 
            else if (c == '['){
                // just push the currentstring and currentnumber
                countStack.push(countNumber);
                stringStack.push(currentString);
                
                // reset into the new substring
                currentString = "";
                countNumber =0;
            } else if(c == ']'){
                // Pop number and previous string from stacks
                int repeatCount= countStack.pop();
                String previousString = stringStack.pop();
                
                 // Repeat the current string and append to the previous string
                StringBuilder repeatedString = new StringBuilder();
                for(int i =0;i<repeatCount;i++){
                    repeatedString.append(currentString);
                }
                currentString = previousString + repeatedString.toString();
                
            }else {
                // Append character to the current string
                currentString += c;
            }
        }
        return currentString;
        
    }
}