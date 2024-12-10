class Solution {
public boolean isSubsequence(String s, String t) {
if(s == null || t == null) return false;
if(s.isEmpty()) return true;
HashMap<Character,Integer> mapS = new HashMap<>();
HashMap<Character,Integer> mapT = new HashMap<>();
for(int i = 0;i<s.length();i++){
mapS.put(s.charAt(i),i);
}
for(int j = 0;j<t.length();j++){
mapT.put(t.charAt(j),j);
}
int index = -1;
for(char c:s.toCharArray()){
if(!mapT.containsKey(c)){
return false;
}
int currentIndex = mapT.get(c);
if(currentIndex<=index){
return false;
}
}
return true;
}
} but it will failure for the some particular test cases