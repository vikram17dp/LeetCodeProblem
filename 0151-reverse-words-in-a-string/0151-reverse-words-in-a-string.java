class Solution { // tc is O(n) and sc is O(1)
    public String reverseWords(String s) {
       char[] arr = s.toCharArray();
       int n = arr.length;

       // step1: reverse full string 
       reverse(arr,0,n-1);

       // step2: reverese each words beacuse all words got reverse ex: blue -> eulb
       int start = 0;
       for(int end = 0;end<=n;end++){
            if(end == n || arr[end] == ' '){
                reverse(arr,start,end-1);
                start = end+1;
            }
       }
        // step3: remove extra space
        return cleanSpaces(arr);

    }
    public void reverse(char[] arr,int i ,int j){
        while(i<j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
    public String cleanSpaces(char[] arr){
        int i = 0,j = 0;
        int n = arr.length;
        while(j<n){ // skip spaces
            while(j<n && arr[j] == ' '){
                j++;
            }
            while(j<n && arr[j] != ' '){ // cppy words
                arr[i++] = arr[j++];
            }
            while(j<n && arr[j] == ' '){ // skip spaces again
                j++;
            }
            if(j<n) arr[i++] = ' '; // add single space b/t words
        }
        return new String(arr,0,i);
    }
} 