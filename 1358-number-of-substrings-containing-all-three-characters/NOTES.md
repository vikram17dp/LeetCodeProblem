class Solution { // tc is O(n2) and sc is O(1)
public int numberOfSubstrings(String s) {
int n = s.length();
int count = 0;
for(int i = 0;i<n;i++){
int[] charCount = new int[3];
for(int j = i;j<n;j++){
charCount[s.charAt(j)-'a']++;
if(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0){
count++;
}
}
}
return count;
}
}